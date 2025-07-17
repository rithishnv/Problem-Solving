class Solution {
    public int maximumLength(int[] nums, int k) {
       int res=2;
       for(int i=0;i<k;i++){
        int[] dp=new int[k];
        for(int j=0;j<nums.length;j++){
            int mod=nums[j]%k;
            int ind=(i-mod+k)%k;
            dp[mod]=dp[ind]+1;
        }
        for(int val:dp)
        res=Math.max(val,res);
       }
       return res;
    }
}