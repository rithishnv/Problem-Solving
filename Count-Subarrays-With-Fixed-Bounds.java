class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res=0,left=-1,right=-1,l=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<minK || nums[i]>maxK){
                l=i;
            }
            if(nums[i]==minK)
            left=i;
            if(nums[i]==maxK)
            right=i;
            res+=Math.max(0,Math.min(left,right)-l);
        }
        return res;
    }
}