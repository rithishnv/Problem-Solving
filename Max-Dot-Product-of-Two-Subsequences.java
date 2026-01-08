1class Solution {
2    public int maxDotProduct(int[] nums1, int[] nums2) {
3         int n = nums1.length, m = nums2.length, dp[][] = new int[n][m];
4        for (int i = 0; i < n; ++i) {
5            for (int j = 0; j < m; ++j) {
6                dp[i][j] = nums1[i] * nums2[j];
7                if (i > 0 && j > 0) dp[i][j] += Math.max(dp[i-1][j-1], 0);
8                if (i > 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
9                if (j > 0) dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
10            }
11        }
12        return dp[n-1][m-1];
13    }
14}