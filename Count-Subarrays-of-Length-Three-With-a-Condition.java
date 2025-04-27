class Solution {
    public int countSubarrays(int[] nums) {
        int r=0;
        for(int i=0;i<nums.length;i++){
            if(i+2 <nums.length)
            if(nums[i]+nums[i+2]==(float)nums[i+1]/2)
                r++;
        }
        return r;
    }
}