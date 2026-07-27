class Solution {
    public int maxProduct(int[] nums) {
     Arrays.sort(nums);
     int a=nums.length;
     return ((nums[a-1]-1)*(nums[a-2]-1));
    }
}