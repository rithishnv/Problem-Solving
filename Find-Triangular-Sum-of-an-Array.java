class Solution {
    public int sum(int[] nums,int n){
        if(n==0)
        return nums[0];
        for(int i=0;i<n;i++){
            nums[i]=(nums[i]+nums[i+1])%10;
        }
        return sum(nums,n-1);
    }
    public int triangularSum(int[] nums) {
        return sum(nums,nums.length-1);
    }
}