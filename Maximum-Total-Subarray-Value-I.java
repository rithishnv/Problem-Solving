1class Solution {
2    public long maxTotalValue(int[] nums, int k) {
3        int a=Integer.MAX_VALUE;
4        int b=Integer.MIN_VALUE;
5        for(int i:nums){
6            a=Math.min(a,i);
7            b=Math.max(b,i);
8        }
9        return (long)(b-a)*k;
10    }
11}