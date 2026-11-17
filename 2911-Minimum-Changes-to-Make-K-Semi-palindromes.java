class Solution {
    public int minimumChanges(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        if (1 == k){
            return cal(cs, 0, n - 1);
        }
        int[][] cost = new int[n][n];
        for (int l = 2; l <= n; ++l) {
            for (int i = 0; i + l <= n; ++i) {
                cost[i][i + l - 1] = cal(cs, i, i + l - 1);
            }
        }        
        int[] dp = new int[n];
        for (int i = 1; i < n; ++i) dp[i] = cost[0][i];
        for (int i = 1; i < k; ++i) {
            for (int j = n - 1; i << 1 < j; --j) {
                dp[j] = n;
                for (int l = i << 1; l < j; ++l) {
                    dp[j] = Math.min(dp[j], cost[l][j] + dp[l - 1]);
                }
            }
        }
        return dp[n - 1];
    }
    private int cal(char[] cs, int start, int end) {
        int len = end - start + 1, res = len;
        for (int d = 1; d < len; ++d) {
            if (0 != len % d) continue;
            int cnt = 0;            
            for (int i = 0; i < d; ++i) {
                for (int j = start + i, k = end - (end - j) % d; j < k; j += d, k -= d) {
                    if (cs[j] != cs[k]) cnt++;
                }
            }
            res = Math.min(res, cnt);
        }
        return res;
    }
}