1class Solution {
2    public long maxSubarraySum(int[] nums, int k) {
3        int n=nums.length;
4        long[] arr=new long[n+1];
5        for(int i=0;i<n;i++){
6            arr[i+1]=arr[i]+nums[i];
7        }
8        long res=Long.MIN_VALUE;
9        for(int i=0;i<k;i++){
10            long temp=0;
11            for(int j=i;j+k<=n;j+=k){
12                long sum=arr[j+k]-arr[j];
13                temp=Math.max(sum,temp+sum);
14                res=Math.max(temp,res);
15            }
16        }
17        return res;
18    }
19}