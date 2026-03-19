1class Solution {
2    public int numberOfSubmatrices(char[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        int ans = 0;
5
6        int[] px = new int[n];
7        int[] py = new int[n];
8
9        for (int i = 0; i < m; i++) {
10            int rowX = 0, rowY = 0;
11
12            for (int j = 0; j < n; j++) {
13                if (grid[i][j] == 'X') rowX++;
14                else if (grid[i][j] == 'Y') rowY++;
15
16                px[j] += rowX;
17                py[j] += rowY;
18
19                if (px[j] == py[j] && px[j] > 0) {
20                    ans++;
21                }
22            }
23        }
24
25        return ans;
26    }
27}