1class Solution {
2    public int largestAltitude(int[] gain) {
3        int res=0;
4        int temp=0;
5        for(int i:gain){
6            temp+=i;
7            res=Math.max(res,temp);
8        }
9        return res;
10    }
11}