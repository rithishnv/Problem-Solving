class Solution {
    public long maximumTripletValue(int[] nums) {
        int val=0;
        int diff=0;
        long ans=0;
        for(int n:nums){
            ans=Math.max(ans,(long)diff*n);
            val=Math.max(val,n);
            diff=Math.max(diff,val-n);
        }
        return ans;
    }
}