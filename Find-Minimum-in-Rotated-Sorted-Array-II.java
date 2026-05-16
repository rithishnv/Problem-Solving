1class Solution {
2    public int search(int[] n,int l,int h){
3        while(l<h){
4        int m=l+(h-l)/2;
5        if(n[m]<n[h])
6        h=m;
7        else if(n[m]>n[h])
8        l=m+1;
9        else
10        h--;
11        }
12        return n[l];
13    }
14    public int findMin(int[] nums) {
15        return search(nums,0,nums.length-1);
16    }
17}