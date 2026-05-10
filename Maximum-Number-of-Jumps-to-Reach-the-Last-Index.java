1class Solution {
2    public int maximumJumps(int[] nums, int target) {
3        int n=nums.length;
4        target=Math.abs(target);
5        int[] dp=new int[n];
6        Arrays.fill(dp,-1);
7        dp[0]=0;
8        for(int i=0;i<n;i++){
9            if(i>0 && dp[i]<=0){
10                continue;
11            }
12            for(int j=i+1;j<n;j++){
13                if(Math.abs(nums[i]-nums[j])<=target){
14                    dp[j]=Math.max(dp[j],dp[i]+1);
15                }
16            }
17        }
18        return dp[n-1];
19    }
20}