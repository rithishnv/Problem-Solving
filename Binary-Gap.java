1class Solution {
2    public int binaryGap(int n) {
3        int res=0,st=0,ed=0,t=0;
4        while(n>0){
5            if(n%2==1){
6                if(++t>1)
7                res=Math.max(Math.abs(ed-st),res);
8                ed=st;
9            }
10            st++;
11            n/=2;
12        }
13        return res;
14    }
15}