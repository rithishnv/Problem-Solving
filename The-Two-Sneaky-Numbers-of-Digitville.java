class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res=new int[2];
        int j=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                res[j++]=nums[i];
            }
        }
        return res;
    }
}