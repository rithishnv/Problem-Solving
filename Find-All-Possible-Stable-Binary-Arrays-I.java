1class Solution {
2    int MOD = 1_000_000_007;
3    
4    public int numberOfStableArrays(int zero, int one, int limit) {
5        long[][][] dp = new long[zero+1][one+1][2];
6        dp[0][0][0] = dp[0][0][1]=1;
7        
8        for(int i=0; i<=zero; i++){
9            for(int j=0; j<=one; j++){
10                for(int k=1; k<=limit; k++){
11                    if(i-k>=0){
12                        dp[i][j][1] = (dp[i][j][1]+dp[i-k][j][0])%MOD;
13                    }
14                    if(j-k>=0){
15                        dp[i][j][0]=(dp[i][j][0]+dp[i][j-k][1])%MOD;
16                    }
17                }
18            }
19        }
20        return (int)((dp[zero][one][0]+dp[zero][one][1])%MOD);
21    }
22}