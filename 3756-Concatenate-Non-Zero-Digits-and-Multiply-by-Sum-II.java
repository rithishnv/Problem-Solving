class Solution {
    int MOD = 1000000007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = queries.length;
        int m = s.length();
        long[] sum = new long[m];
        long[] x = new long[m];
        int[] len = new int[m];
        int[] ans = new int[n];
        long[] power10 = new long[m+1];
        power10[0] = 1;
        for(int i=1;i<=m;i++){
            power10[i] = (power10[i-1]*10)%MOD;
        }
        for (int i = 0; i < m; i++) {
            int digit = s.charAt(i) - '0';
            sum[i] = (i==0)? digit : digit+sum[i-1];
            if(i == 0){
                x[i] = digit;
            }
            else{
                if(digit == 0)
                    x[i] = x[i-1];
                else
                    x[i] = (x[i-1] * 10 + digit) % MOD;
            }
            if(i==0){
                len[i]=(digit==0)?0:1;
            }   
            else{
                len[i]=(digit==0)?len[i-1]:len[i-1]+1;
            }
        }
        for(int i=0;i<n;i++){
            int l = queries[i][0], r = queries[i][1];
            long sumQ=0,power=0,xQ=0;
            if(l==0){
                sumQ=sum[r];
                xQ = x[r];
            }else{
                sumQ = ((sum[r] - sum[l-1]) + MOD) % MOD;
                long lenCut = len[r] - ((l>0)? len[l-1] : 0); 
                xQ= (x[r]- (x[l-1]*power10[(int)lenCut]%MOD) + MOD)% MOD;
            }
            ans[i]=(int)(((xQ%MOD)*(sumQ%MOD))%MOD);
        }

        return ans;
    }
}