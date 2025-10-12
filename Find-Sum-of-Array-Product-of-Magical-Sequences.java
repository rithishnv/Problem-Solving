class Solution {
    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        long mod = 1000000007, arr[] = new long[m+1];
        arr[0] = 1;
        for(int i=1;i<=m;i++){
            arr[i] = (arr[i-1]*i)%mod;
        }
        long[] a = new long[m+1];
        a[0] = 1;
        a[1] = 1;
        for(int i=2;i<=m;i++){
            a[i] = quickmul(i,mod-2,mod);
        }
        for(int i=2;i<=m;i++){
            a[i] = (a[i-1]*a[i])%mod;
        }
        long[][] nu = new long[n][m+1];
        for(int i=0;i<n;i++){
            nu[i][0] = 1;
            for(int j=1;j<=m;j++){
                nu[i][j] = (nu[i][j-1]*nums[i])%mod;
            }
        }
        long[][][][] f = new long[n][m+1][m*2+1][k+1];
        for(int j=0;j<=m;j++){
            f[0][j][j][0] = (nu[0][j]*a[j])%mod;
        }
        for(int i=0;i+1<n;i++){
            for(int j=0;j<=m;j++){
                for(int p=0;p<=m*2;p++){
                    for(int q=0;q<=k;q++){
                        int q2 = (p%2)+q;
                        if(q2>k){
                            break;
                        } 
                        for(int r=0;r+j<=m;r++){
                            int p2=p/2+r;
                            f[i+1][j+r][p2][q2] += (((f[i][j][p][q]*nu[i+1][r])%mod)*a[r])%mod;
                            f[i+1][j+r][p2][q2] %= mod;
                        }
                    }
                }
            }
        }
        long res = 0;
        for(int p=0;p<=m*2;p++){
            for(int q=0;q<=k;q++){
                if(Integer.bitCount(p)+q==k){
                    res = (res+((f[n-1][m][p][q]*arr[m])%mod))%mod;
                }
            }
        }
        return (int)res;
    }
    public long quickmul(long x,long y,long mod){
        long res = 1, cur = x%mod;
        while(y>0){
            if((y&1)==1){
                res = (res*cur)%mod;
            }
            y>>=1;
            cur = (cur*cur)%mod;
        }
        return res;
    }
}