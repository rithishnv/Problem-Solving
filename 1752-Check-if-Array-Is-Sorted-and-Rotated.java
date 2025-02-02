class Solution {
    public boolean check(int[] nums) {
        int cnt=0,n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%n])
            cnt++;
        }
        return cnt<=1;
    }
}