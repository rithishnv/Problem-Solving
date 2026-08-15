class Solution {
    public int longestSubsequence(int[] nums) {
        int res=0;
        int n=nums.length;
        boolean flag=false;
        for(int i:nums){
            res^=i;
            if(res!=0){
                flag=true;
            }
        }
        if(res!=0){
            return n;
        }
        else if(!flag){
            return 0;
        }
        return n-1;
    }
}