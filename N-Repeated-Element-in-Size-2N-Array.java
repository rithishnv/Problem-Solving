1class Solution {
2    public int repeatedNTimes(int[] nums) {
3        int n=nums.length;
4        int[] arr=new int[100001];
5        for(int i:nums){
6            arr[i]++;
7            if(arr[i]>1)
8            return i;
9        }
10        return 0;
11    }
12}