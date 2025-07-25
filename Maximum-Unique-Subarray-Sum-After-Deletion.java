class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int n=nums.length;
        Arrays.sort(nums);
        int s=0;
        for(int i=n-1;i>-1;i--){
            if(set.add(nums[i]) && nums[i]>0){
                s+=nums[i];
            }
        }
        return (nums[n-1]<=0)?nums[n-1]:s;
    }
}