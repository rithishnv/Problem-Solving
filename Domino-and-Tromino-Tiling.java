class Solution {
    public int numTilings(int n) {
        int mod=1000000007;
        long[] fill=new long[n+1];
        long[] partial=new long[n+1];
        if(n<=2)
        return n;
        fill[1]=1;
        fill[2]=2;
        partial[2]=1;
        for(int i=3;i<=n;i++){
            fill[i]=(fill[i-1]+fill[i-2]+2*partial[i-1])%mod;
            partial[i]=(partial[i-1]+fill[i-2])%mod;
        }
        return (int)fill[n];
    }
}