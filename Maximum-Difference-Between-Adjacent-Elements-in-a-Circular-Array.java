class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int m=Math.abs(nums[0]-nums[nums.length-1]);
        for(int i=0;i<nums.length-1;i++){
            m=Math.max(m,Math.abs(nums[i]-nums[i+1]));
        }
        return m;
    }
    
}