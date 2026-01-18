1class Solution {
2    public int largestMagicSquare(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5        if (n < 2 || m < 2) return 1;
6
7        long[][] row = new long[n][m + 1];
8        long[][] col = new long[n + 1][m];
9        long[][] d1 = new long[n + 1][m + 2];
10        long[][] d2 = new long[n + 1][m + 2];
11
12        for (int i = 0; i < n; i++) {
13            for (int j = 0; j < m; j++) {
14                row[i][j + 1] = row[i][j] + grid[i][j];
15                col[i + 1][j] = col[i][j] + grid[i][j];
16                d1[i + 1][j + 1] = d1[i][j] + grid[i][j];
17                d2[i + 1][j] = d2[i][j + 1] + grid[i][j];
18            }
19        }
20
21        for (int k = Math.min(n, m); k > 1; k--) {
22            for (int r = 0; r <= n - k; r++) {
23                for (int c = 0; c <= m - k; c++) {
24                    long target = row[r][c + k] - row[r][c];
25
26                    if (d1[r + k][c + k] - d1[r][c] != target) continue;
27                    if (d2[r + k][c] - d2[r][c + k] != target) continue;
28
29                    boolean match = true;
30                    for (int i = 0; i < k; i++) {
31                        if (row[r + i][c + k] - row[r + i][c] != target) {
32                            match = false;
33                            break;
34                        }
35                    }
36                    if (!match) continue;
37
38                    for (int j = 0; j < k; j++) {
39                        if (col[r + k][c + j] - col[r][c + j] != target) {
40                            match = false;
41                            break;
42                        }
43                    }
44
45                    if (match) return k;
46                }
47            }
48        }
49        return 1;
50    }
51}