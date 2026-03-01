1class Solution {
2    public int minPartitions(String n) {
3        char r='0';
4        for(char i:n.toCharArray()){
5            if(i>r)
6            r=i;
7        }
8        return r-'0';
9    }
10}