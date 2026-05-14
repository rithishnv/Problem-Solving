1class Solution {
2    public boolean isGood(int[] nums) {
3        Arrays.sort(nums);
4        if(nums[nums.length-1]+1!=nums.length)
5            return false;        
6        for(int i=0;i<nums.length-1;i++){
7            if(nums[i]!=i+1)
8            return false;
9        }
10        if(nums[nums.length-1]!=nums[nums.length-2])
11        return false;
12        return true;
13    }
14}