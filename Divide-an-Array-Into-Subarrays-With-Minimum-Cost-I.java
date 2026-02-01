1class Solution {
2    public int minimumCost(int[] nums) {
3        int r=nums[0];
4        nums[0]=100;
5        Arrays.sort(nums);
6        return r+nums[0]+nums[1];
7    }
8}