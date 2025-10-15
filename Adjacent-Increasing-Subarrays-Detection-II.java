class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int pre=0,t=1,res=0;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)>nums.get(i-1)){
                t++;
            }
            else{
                pre=t;
                t=1;
            }
            res=Math.max(res,Math.max(t/2,Math.min(t,pre)));
        }
        return res;
    }
}