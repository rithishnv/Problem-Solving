1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3        StringBuilder s=new StringBuilder();
4        for(String i:words){
5            int t=0;
6            for(char j:i.toCharArray()){
7                t+=weights[j-'a'];
8            }
9            s.append((char)('z'-(t%26)));
10        }
11        return s.toString();
12    }
13}