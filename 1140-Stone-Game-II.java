class Solution {
    int[][] memo;
    int[] sfx;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        sfx = new int[n + 1];
        memo = new int[n][n + 1];
        for (int i = n - 1; i >= 0; i--){
            sfx[i] = sfx[i + 1] + piles[i];
        }
        return dfs(0, 1);
    }
    public int dfs(int i , int M) {
        if (i + 2 * M >= sfx.length - 1){
            return sfx[i];
        }
        if (memo[i][M] > 0){
            return memo[i][M];
        }
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * M; x++) {
            min = Math.min(min, dfs(i + x, Math.max(M, x)));
        }
        return memo[i][M] = sfx[i] - min;
    }
}