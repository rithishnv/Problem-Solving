1class Solution {
2    public int minPairSum(int[] nums) {
3        Arrays.sort(nums);
4        int max=Integer.MIN_VALUE;
5        int i=0,j=nums.length-1;
6        while(i<j){
7            max=Math.max(max,nums[i++]+nums[j--]);
8        }
9        return max;
10    }
11}