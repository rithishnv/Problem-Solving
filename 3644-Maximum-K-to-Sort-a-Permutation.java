class Solution {
    public int sortPermutation(int[] nums) {
        int res=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]){
               res&=nums[i]; 
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}