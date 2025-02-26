class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min=0,max=0,sum=0;
        for(int i=0;i<nums.length;i++){
            sum=Math.max(nums[i],sum+nums[i]);
            if(sum>max)
            max=sum;
        }
        sum=0;
        for(int i=0;i<nums.length;i++){
            sum=Math.min(nums[i],sum+nums[i]);
            if(sum<min)
            min=sum;
        }
        return Math.max(max,Math.abs(min));
    }
}