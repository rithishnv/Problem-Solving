1class Solution {
2    public long maximumHappinessSum(int[] happiness, int k) {
3        int n=happiness.length-1;
4        long mh=0;
5        int i,p=0;
6        Arrays.sort(happiness);
7        for(i=0;i<k;i++){
8            if((happiness[n]-p)>0)
9            mh+=happiness[n]-p;
10            p++;
11            n--;
12        }
13        return mh;
14    }
15}