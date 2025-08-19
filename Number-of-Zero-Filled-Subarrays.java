class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long t=0;
        long res=0;
        for(int n:nums){
            if(n==0){
                t++;
                res+=t;
            }
            else{
                t=0;
            }
        }
        return res;
    }
}