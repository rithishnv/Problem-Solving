class Solution {
    public int idealArrays(int n, int m) {
        int mod=1000000007;
        int[][] dp=new int[m+1][15];
        for(int i=1;i<=m;i++){
            dp[i][1]=1;
        }
        for(int j=1;j<14;j++){
            for(int i=1;i<=m;i++){
                for(int k=2;i*k<=m;k++){
                    dp[k*i][j+1]=(dp[i][j]+dp[k*i][j+1])%mod;
                }
            }
        }
        long[][] c=new long[n][15];
        for(int i=0;i<n;i++){
            for(int j=0;j<15 && j<=i;j++){
                if(j==0)
                c[i][j]=1;
                else
                c[i][j]=(c[i-1][j-1]+c[i-1][j])%mod;
            }
        }
        long res=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<15 && j<=n;j++){
                res=(res+dp[i][j] * c[n-1][j-1])%mod;
            }
        }
        return (int)res;
    }
}