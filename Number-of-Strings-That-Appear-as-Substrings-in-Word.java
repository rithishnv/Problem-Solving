1class Solution {
2    public int numOfStrings(String[] patterns, String word) {
3        int res=0;
4        for(String s:patterns){
5            if(word.indexOf(s)>=0){
6                res++;
7            }
8        }
9        return res;
10    }
11}