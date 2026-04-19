1class Solution {
2    public int maxDistance(int[] nums1, int[] nums2) {
3        int i=0,j=0;
4        int res=0;
5        int n=nums1.length,m=nums2.length;
6        while(i<n && j<m){
7            if(nums1[i]<=nums2[j]){
8                res=Math.max(res,j-i);
9                j++;
10            }
11            else
12             i++;
13        }
14        return res;
15    }
16}