class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int m=nums[n/2];
        int res=0;
        for(int i:nums){
            res+=Math.abs(m-i);
        }
        return res;
    }
}