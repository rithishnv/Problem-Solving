1class Solution {
2    public int[] leftRightDifference(int[] nums) {
3      int lsum=0,rsum=0;
4      int n=nums.length;
5      for(int i=n-1;i>0;i--){
6        rsum+=nums[i];
7      }
8      for(int i=0;i<n-1;i++){
9        int t=nums[i];
10        nums[i]=Math.abs(lsum-rsum);
11        lsum+=t;
12        rsum-=nums[i+1];
13      }  
14      nums[n-1]=Math.abs(lsum-rsum);
15      return nums;
16    }
17}