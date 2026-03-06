1class Solution {
2    public boolean checkOnesSegment(String s) {
3        int n=s.length();
4        boolean t=false;
5        for(int i=0;i<n;i++){
6            if(s.charAt(i)=='1'){
7                if(t)
8                return false;
9                while(i<n && s.charAt(i++)=='1');
10                t=!t;
11                i--;
12            }
13        }
14        return true;
15    }
16}