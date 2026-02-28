1class Solution {
2    public int concatenatedBinary(int n) {
3        long res=0;
4        int mod=(int)(1e9+7),c=0;
5        for(int i=1;i<=n;i++){
6            if((i & (i-1))==0)
7            c++;
8            res=((res<<c)|i)%mod;
9        }
10        return (int)res;
11    }
12}