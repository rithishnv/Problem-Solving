class Solution {
    public int[] buildArray(int[] nums) {
        int[] a=new int[nums.length];
        int j=0;
        for(int i:nums){
            a[j++]=nums[i];
        }
        return a;
    }
}