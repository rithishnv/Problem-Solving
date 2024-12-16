class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k-->0){
            int f=0,min=Integer.MAX_VALUE;
            for(int i=0;i<nums.length;i++){
                if(min>nums[i]){
                min=nums[i];
                f=i;
            }
            }
            nums[f]=multiplier*nums[f];
        }
        return nums;
    }
}