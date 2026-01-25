1class Solution {
2    public int minimumDifference(int[] nums, int k) {
3        Arrays.sort(nums);
4        int n=Integer.MAX_VALUE;
5        for(int i=0;i+k<=nums.length;i++){
6            n=Math.min(nums[i+k-1]-nums[i],n);
7        }
8        return n;
9    }
10}