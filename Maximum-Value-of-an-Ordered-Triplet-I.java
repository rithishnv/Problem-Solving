class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans=0;
        int diff=0;
        int max=0;
        for(int num:nums){
            ans=Math.max(ans,(long)diff*num);
            max=Math.max(max,num);
            diff=Math.max(diff,max-num);
        }
        return ans;
    }
}