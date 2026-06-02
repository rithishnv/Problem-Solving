1class Solution {
2    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
3        int n=landStartTime.length;
4        int m=waterStartTime.length;
5        int res=Integer.MAX_VALUE;
6        for(int i=0;i<n;i++){
7            for(int j=0;j<m;j++){
8                int t=landStartTime[i]+landDuration[i];
9                int a1=Math.max(t,waterStartTime[j])+waterDuration[j];
10                int t1=waterStartTime[j]+waterDuration[j];
11                int a2=Math.max(t1,landStartTime[i])+landDuration[i];
12                res=Math.min(a1,res);
13                res=Math.min(a2,res);
14            }
15        }
16        return res;
17    }
18}