1class Solution {
2    public int search(int[] nums, int target) {
3        int i=0,j=nums.length-1;
4        while(i<=j){
5            int mid=i+(j-i)/2;
6            if(nums[mid]==target){
7                return mid;
8            }
9            if(nums[mid]<nums[j]){
10                if(target>nums[mid] && target<=nums[j]){
11                    i=mid+1;
12                }
13                else{
14                    j=mid-1;
15                }
16            }
17            else{
18                if(target<nums[mid] && target>=nums[i]){
19                    j=mid-1;
20                }
21                else{
22                    i=mid+1;
23                }
24            }
25        }
26        return -1;
27    }
28}