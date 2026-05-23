1class Solution {
2    public boolean check(int[] nums) {
3        int cnt=0,n=nums.length;
4        for(int i=0;i<nums.length;i++){
5            if(nums[i]>nums[(i+1)%n])
6            cnt++;
7        }
8        return cnt<=1;
9    }
10}