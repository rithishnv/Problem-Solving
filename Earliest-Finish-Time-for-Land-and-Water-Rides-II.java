1class Solution {
2    public int calFinishTime(int[] ls, int[] ld,int[] ws, int[] wd) {
3        int mini = Integer.MAX_VALUE;
4        for (int i = 0; i < ls.length; i++) {
5            mini = Math.min(mini, ls[i] + ld[i]);
6        }
7        int ans = Integer.MAX_VALUE;
8        for (int i = 0; i < ws.length; i++) {
9            ans = Math.min(ans,Math.max(mini, ws[i]) + wd[i]);
10        }
11        return ans;
12    }
13    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
14        return Math.min(
15            calFinishTime(landStartTime,landDuration,waterStartTime,waterDuration),
16            calFinishTime(waterStartTime,waterDuration,landStartTime,landDuration)
17        );
18    }
19}