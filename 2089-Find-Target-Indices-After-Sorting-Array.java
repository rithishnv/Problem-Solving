class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                while(i<n && nums[i]==target){
                    res.add(i++);
                }
                return res;
            }
        }
        return res;
    }
}