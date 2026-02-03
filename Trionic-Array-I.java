1class Solution {
2    public boolean isTrionic(int[] nums) {
3        int i=0,j=0;
4        int n=nums.length;
5        for(int k=0;k<n-1;k++){
6            if(nums[k]>nums[k+1]){
7                i=k;
8                break;
9                }
10            else if(nums[k]==nums[k+1]){
11                return false;
12            }
13        }
14        if(i==0 || i>=n-1)
15        return false;
16        for(int k=i;k<n-1;k++){
17            if(nums[k]<nums[k+1]){
18                j=k;
19                break;
20            }
21            else if(nums[k]==nums[k+1]){
22                return false;
23            }
24        }
25        if(j==0 || j>=n-1)
26        return false;
27        for(int k=j;k<n-1;k++){
28            if(nums[k]>nums[k+1] || nums[k]==nums[k+1]){
29                return false;
30            }
31        }
32        return true;
33    }
34}