class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long res=0;
        long[] dp=new long[n+1];
        for(int i=n-1;i>-1;i--){
            long next=dp[i+1];
            int ind=i+questions[i][1]+1;
            long curr=questions[i][0];
            if(ind<n){
                curr+=dp[ind];
            }
            dp[i]=Math.max(curr,next);
        }
        return dp[0];
    }
}