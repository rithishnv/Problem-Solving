class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int last=0;
        int n=startTime.length;
        int res=0;
        int maxLeft=0;
        int[] gap=new int[n+1];
        for(int i=0;i<n;i++){
            gap[i]=startTime[i]-last;
            last=endTime[i];
        }
        gap[n]=eventTime-last;
        int[] maxRight=new int[n+1];
        for(int i=n-1;i>=0;i--){
            maxRight[i]=Math.max(maxRight[i+1],gap[i+1]);
        }
        for(int i=1;i<=n;i++){
            int time=endTime[i-1]-startTime[i-1];
            if(maxLeft>=time || maxRight[i]>=time)
            res=Math.max(res,gap[i-1]+time+gap[i]);
            res=Math.max(res,gap[i-1]+gap[i]);
            maxLeft=Math.max(maxLeft,gap[i-1]);
        }
        return res;
    }
}