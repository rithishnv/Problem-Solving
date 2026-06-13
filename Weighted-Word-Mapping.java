1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3        StringBuilder s=new StringBuilder();
4        for(String i:words){
5            int t=0;
6            for(char j:i.toCharArray()){
7                t+=weights[j-'a'];
8            }
9            t%=26;
10            s.append((char)('a'+(26-t-1)));
11        }
12        return s.toString();
13    }
14}