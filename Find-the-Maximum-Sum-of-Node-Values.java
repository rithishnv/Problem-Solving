class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
    long res=0,cnt=0,min=Integer.MAX_VALUE;
    for(int i:nums){
        int a=i^k;
        res+=Math.max(i,a);
        cnt^=(a>i)?1:0;
        min=Math.min(min,Math.abs(i-(i^k)));
    }
    return res-min*cnt;
    }
}