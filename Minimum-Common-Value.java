1class Solution {
2    public int getCommon(int[] nums1, int[] nums2) {
3        int n1=nums1.length,n2=nums2.length;
4        int i=0,j=0;
5        while(i<n1 && j<n2){
6            if(nums1[i]==nums2[j]){
7                return nums1[i];
8            }
9            else if(nums1[i]>nums2[j]){
10                j++;
11            }
12            else{
13                i++;
14            }
15        }
16        return -1;
17    }
18}