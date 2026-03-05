1class Solution {
2    public int minOperations(String s) {
3        int c=0,t=0;
4        for(char i:s.toCharArray()){
5            if((i=='0' && t!=0) || (i=='1'&& t!=1))
6                c++;
7            t=(t==0)?1:0;
8        }
9        return Math.min(s.length()-c,c);
10    }
11}