1class Solution {
2    int n, K;
3    int[] p;
4    Long[][][] dp;
5    final long NEG = (long)-1e18;
6
7    long dfs(int i, int t, int s) {
8        if (i == n) return s == 0 ? 0 : NEG;
9        if (dp[i][t][s] != null) return dp[i][t][s];
10
11        long res = dfs(i + 1, t, s);
12
13        if (s == 0) {
14            res = Math.max(res, dfs(i + 1, t, 1) - p[i]);
15            res = Math.max(res, dfs(i + 1, t, 2) + p[i]);
16        } else if (s == 1 && t < K) {
17            res = Math.max(res, dfs(i + 1, t + 1, 0) + p[i]);
18        } else if (s == 2 && t < K) {
19            res = Math.max(res, dfs(i + 1, t + 1, 0) - p[i]);
20        }
21
22        return dp[i][t][s] = res;
23    }
24
25    public long maximumProfit(int[] prices, int k) {
26        p = prices;
27        n = prices.length;
28        K = k;
29        dp = new Long[n + 1][k + 1][3];
30        return dfs(0, 0, 0);
31    }
32}