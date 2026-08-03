class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            int csum = 0;
            for (int j = 0; j < 3 && i + j < n; j++) {
                csum += stoneValue[i + j];
                dp[i] = Math.max(dp[i],csum - dp[i + j + 1]);
            }
        }
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}