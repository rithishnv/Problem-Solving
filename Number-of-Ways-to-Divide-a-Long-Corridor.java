1class Solution {
2    public int numberOfWays(String corridor) {
3        long j=0,res=1,mod=(long)1e9+7,k=0;
4        for(int i=0;i<corridor.length();i++){
5            if(corridor.charAt(i)=='S'){
6                k++;
7                if(k>2 && k%2==1){
8                    res=res*(i-j)%mod;
9                }
10                j=i;
11            }
12        }
13        return k%2==0 && k>0 ? (int)res:0;
14    }
15}