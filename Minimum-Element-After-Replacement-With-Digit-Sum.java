1class Solution {
2    public int minElement(int[] nums) {
3        int min=Integer.MAX_VALUE;
4        for(int i:nums){
5            int sum=0;
6            while(i>0){
7                sum+=i%10;
8                i/=10;
9            }
10            min=Math.min(sum,min);
11        }
12        return min;
13    }
14}