class Solution {
    public int maxAscendingSum(int[] nums) {
        int t=nums[0],s=nums[0],sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=(nums[i]>nums[i-1])?sum+nums[i]:nums[i];
            s=Math.max(sum,s);
        }
        return s;
    }
}