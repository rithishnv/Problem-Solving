class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long res=0;
        Arrays.sort(nums);
        int n=nums.length;
        return count(nums,upper)-count(nums,lower-1);
    }
    public long count(int[] nums,int tar){
        long res=0;
        int i=0,j=nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]>tar){
                j--;
            }
            else{
            res+=j-i;
            i++;
            }
        }
        return res;
    }
}