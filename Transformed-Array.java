1class Solution {
2    public int[] constructTransformedArray(int[] nums) {
3        int n=nums.length;
4        int[] res=new int[n];
5        for(int i=0;i<n;i++){
6            int t=(i+nums[i])%n;
7            if(t<0)
8            t+=n;
9            res[i]=nums[t];
10        }
11        return res;
12    }
13}