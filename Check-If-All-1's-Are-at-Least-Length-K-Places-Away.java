class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int t=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                t=0;
                i++;
                while(i<nums.length && nums[i]==0){
                    i++;
                    t++;
                }
                if(i>=nums.length)
                return true;
                if(t<k){
                    return false;
                }
                i--;
            }
        }
        return true;
    }
}