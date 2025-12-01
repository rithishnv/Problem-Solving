1class Solution {
2    public long maxRunTime(int n, int[] batteries) {
3        Arrays.sort(batteries);
4        long sum=0;
5        for(int i:batteries){
6            sum+=i;
7        }
8        int k=0,t=batteries.length;
9        while(batteries[t-1-k]>sum/(n-k)){
10            sum-=batteries[t-1-k];
11            k++;
12        }
13        return sum/(n-k);
14    }
15}