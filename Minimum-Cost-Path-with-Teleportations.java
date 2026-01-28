1class Solution {
2    public int minCost(int[][] grid, int k) {
3        int n = grid.length, m = grid[0].length;
4
5        int maxVal = 0;
6        for (int[] row : grid)
7            for (int v : row)
8                maxVal = Math.max(maxVal, v);
9
10        int[][] dp = new int[n][m];
11        int[] bestVal = new int[maxVal + 1];
12        int[] prefix = new int[maxVal + 1];
13
14        Arrays.fill(bestVal, Integer.MAX_VALUE);
15        bestVal[grid[n - 1][m - 1]] = 0;
16
17        for (int i = n - 1; i >= 0; i--) {
18            for (int j = m - 1; j >= 0; j--) {
19                if (i == n - 1 && j == m - 1)
20                    continue;
21
22                int down = i + 1 < n ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE;
23                int right = j + 1 < m ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE;
24
25                dp[i][j] = Math.min(down, right);
26                bestVal[grid[i][j]] = Math.min(bestVal[grid[i][j]], dp[i][j]);
27            }
28        }
29
30        for (int step = 0; step < k; step++) {
31            prefix[0] = bestVal[0];
32            for (int v = 1; v <= maxVal; v++)
33                prefix[v] = Math.min(prefix[v - 1], bestVal[v]);
34
35            for (int i = n - 1; i >= 0; i--) {
36                for (int j = m - 1; j >= 0; j--) {
37                    if (i == n - 1 && j == m - 1)
38                        continue;
39
40                    int walk = Math.min(
41                            i + 1 < n ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE,
42                            j + 1 < m ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE);
43
44                    dp[i][j] = Math.min(walk, prefix[grid[i][j]]);
45                    bestVal[grid[i][j]] = Math.min(bestVal[grid[i][j]], dp[i][j]);
46                }
47            }
48        }
49
50        return dp[0][0];
51    }
52}