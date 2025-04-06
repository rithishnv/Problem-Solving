class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int[] dp=new int[n];
        int[] pre=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(pre,-1);
        int ind=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i] <dp[j]+1){
                    dp[i]=dp[j]+1;
                    pre[i]=j;
                }
            }
            if(dp[i]>dp[ind])
            ind=i;
        }
        List<Integer> li=new ArrayList<>();
        while(ind!=-1){
            li.add(nums[ind]);
            ind=pre[ind];
        }
        return li;
    }
}