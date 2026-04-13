1class Solution {
2    public int getMinDistance(int[] nums, int target, int start) {
3        int i=start-1,j=start+1;
4        if(nums[start]==target)
5        return 0;
6        int n=nums.length;
7        while(true){
8            if(i>-1){
9                if(nums[i]==target)
10                return Math.abs(i-start);
11                i--;
12            }
13            if(j<n){
14                if(nums[j]==target)
15                return Math.abs(j-start);
16                j++;
17            }
18        }
19    }
20}