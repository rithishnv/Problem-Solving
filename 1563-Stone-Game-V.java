class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                int best = 0;
                for (int mid = l; mid < r; mid++) {
                    int leftSum = prefix[mid + 1] - prefix[l];
                    int rightSum = prefix[r + 1] - prefix[mid + 1];

                    if (leftSum <= rightSum) {
                        best = Math.max(best, leftSum + dp[l][mid]);
                    }
                    if (rightSum <= leftSum) {
                        best = Math.max(best, rightSum + dp[mid + 1][r]);
                    }
                }
                dp[l][r] = best;
            }
        }

        return dp[0][n - 1];
    }
}