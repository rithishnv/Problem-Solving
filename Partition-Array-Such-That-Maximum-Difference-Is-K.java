class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int min=nums[0];
        int max=nums[0];
        int res=1;
        for(int i:nums){
            min=Math.min(i,min);
            max=Math.max(i,max);
            if(max-min>k){
                res++;
                min=max=i;
            }
        }
        return res;
    }
}