class Solution {
    int MOD = (int) 1e9 + 7;
    int solve(int n, int K) {
        int next[] = new int[K + 1];
        next[0] = 1;
        int sum[] = new int[K + 1];
        for (int i = n - 1; i >= 0; i--) {
            int curr[] = new int[K + 1];
            curr[0] = 1;
            for (int k = 1; k <= K; k++) {
                int take = 0;
                take = sum[k - 1];
                int skip = next[k];
                curr[k] = (take + skip) % MOD;
            }
            for (int l = 0; l <= K; l++) {
                sum[l] = (sum[l] + curr[l]) % MOD;
            }
            next = curr;
        }
        return next[K];
    }

    public int numberOfSets(int n, int k) {
        return solve(n, k) % MOD;
    }
}