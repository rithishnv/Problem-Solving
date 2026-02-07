1class Solution {
2    public int minimumDeletions(String s) {
3       int res = 0, count = 0;
4        for (char c : s.toCharArray()){
5            if (c == 'b')
6                count++;
7            else if (count != 0){
8                res++;
9                count--;
10            }
11        }
12        return res;
13    }
14}