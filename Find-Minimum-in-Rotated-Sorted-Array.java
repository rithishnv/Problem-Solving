1class Solution {
2    public int search(int[] n,int l,int h){
3        while(l<h){
4        int m=l+(h-l)/2;
5        if(n[m]<n[h])
6        h=m;
7        else
8        l=m+1;
9        }
10        return n[l];
11    }
12    public int findMin(int[] nums) {
13        return search(nums,0,nums.length-1);
14    }
15}