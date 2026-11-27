class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        int[][] factor=new int[n][2];
        for(int i=0; i<n; i++){
            factor[i][0]=items[i][0];
            for(int j=0; j<n; j++){
                if(i != j){
                    if(items[j][0]%items[i][0]==0){
                        factor[i][1]+=1;
                    }
                }
            }
        }
        boolean[] chk=new boolean[n];
        Arrays.fill(chk, false);
        int[][] dp=new int[n+1][budget+1];
        dp[0][0]=0;
        for(int i=1; i<=n; i++){
            for(int j=0; j<=budget; j++){
                dp[i][j]=dp[i-1][j];
                if(j>=items[i-1][1]){
                    dp[i][j]=Math.max(dp[i][j], dp[i-1][j-items[i-1][1]]+1+factor[i-1][1]);
                    dp[i][j]=Math.max(dp[i][j], dp[i][j-items[i-1][1]]+1);
                }
            }
        }
        return dp[n][budget];
    }
}