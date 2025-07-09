class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n=startTime.length;
        int[] gap=new int[n+1];
        gap[0]=startTime[0];
        gap[n]=eventTime-endTime[n-1];
        for(int i=1;i<n;i++){
            gap[i]=startTime[i]-endTime[i-1];
        }
        int[] pre=new int[n+2];
        for(int i=1;i<=n+1;i++){
            pre[i]=pre[i-1]+gap[i-1];
        }
        int max=0;
        for(int i=k+1;i<=n+1;i++){
            max=Math.max(max,pre[i]-pre[i-(k+1)]);
        }
        return max;
    }
}