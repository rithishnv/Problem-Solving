1class Solution {
2    public long getDescentPeriods(int[] prices) {
3        long res=1,cnt=1;
4        for(int i=1;i<prices.length;i++){
5            if(prices[i-1]==prices[i]+1){
6                cnt++;
7            }
8            else
9            cnt=1;
10            res+=cnt;
11        }
12        return res;
13    }
14}