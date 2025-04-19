class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long res=0;
        Arrays.sort(nums);
        int n=nums.length;
        return count(nums,upper)-count(nums,lower-1);
    }
    public long count(int[] nums,int tar){
        long res=0;
        for(int i=0,j=nums.length-1;i<j;i++){
            while(i<j && nums[i]+nums[j]>tar){
                j--;
            }
            res+=j-i;
        }
        return res;
    }
}