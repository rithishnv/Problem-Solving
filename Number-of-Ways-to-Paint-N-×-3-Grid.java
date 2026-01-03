1class Solution {
2    public int numOfWays(int n) {
3        int mod=(int) 1e9+7;
4        long aba=6,abc=6;
5        long n1=0,n2=0;
6        for(int i=1;i<n;i++){
7            n1=(3*aba+2*abc);
8            n2=(2*aba+2*abc);
9            aba=n1%mod;
10            abc=n2%mod;
11        }
12        return (int)(aba+abc)%mod;
13    }
14}