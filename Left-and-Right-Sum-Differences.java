1class Solution {
2    public int[] leftRightDifference(int[] nums) {
3      int lsum=0,rsum=0;
4      int n=nums.length;
5      for(int i=n-1;i>-1;i--){
6        rsum+=nums[i];
7      }
8      for(int i=0;i<n;i++){
9        int t=nums[i];
10        rsum-=nums[i];
11        nums[i]=Math.abs(lsum-rsum);
12        lsum+=t;
13      }  
14      return nums;
15    }
16}