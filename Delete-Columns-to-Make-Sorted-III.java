1class Solution {
2     public int minDeletionSize(String[] A) {
3        int m = A.length, n = A[0].length(), res = n - 1, k;
4        int[] dp = new int[n];
5        Arrays.fill(dp, 1);
6        for (int j = 0; j < n; ++j) {
7            for (int i = 0; i < j; ++i) {
8                for (k = 0; k < m; ++k) {
9                    if (A[k].charAt(i) > A[k].charAt(j)) break;
10                }
11                if (k == m && dp[i] + 1 > dp[j])
12                    dp[j] = dp[i] + 1;
13            }
14            res = Math.min(res, n - dp[j]);
15        }
16        return res;
17    }
18}