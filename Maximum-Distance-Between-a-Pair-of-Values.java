1class Solution {
2    public int maxDistance(int[] nums1, int[] nums2) {
3        int i=0,j=0;
4        int n=nums1.length,m=nums2.length;
5        while(i<n && j<m){
6            if(nums1[i]>nums2[j]){
7                i++;
8            }
9           j++;
10        }
11        return Math.max(j-i-1,0);
12    }
13}