class Solution {
    public int minimizeSum(int[] nums) {
        int n=nums.length;
        if(n==3){
            return 0;
        }
        Arrays.sort(nums);
        int a=nums[n-1]-nums[2];
        int b=nums[n-3]-nums[0];
        int c=nums[n-2]-nums[1];
        return Math.min(a,Math.min(b,c));
    }
}