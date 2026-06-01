1class Solution {
2    public int minimumCost(int[] cost) {
3        Arrays.sort(cost);
4        int res=0;
5        int i=0;
6        for(i=cost.length-1;i-1>-1;i-=3){
7            res+=(cost[i]+cost[i-1]);
8        }
9        if(i>-1){
10            res+=cost[i];
11        }
12        return res;
13    }
14}