1class Solution {
2    public boolean rotateString(String s, String goal) {
3        // for(int i=0;i<s.length();i++){
4        //     if(s.equals(goal))
5        //     return true;
6        //     s= s.substring(s.length()-1)+s.substring(0,s.length()-1);
7        // }
8        if(s.length()!=goal.length())
9        return false;
10        if((s+s).contains(goal))
11        return true;
12        return false;
13    }
14}