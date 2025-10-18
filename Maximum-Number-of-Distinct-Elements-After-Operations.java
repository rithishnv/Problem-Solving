class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int pre=Integer.MIN_VALUE,res=0;
        for(int i:nums){
            int t=Math.max(i-k,pre+1);
            if(t<=i+k){
                pre=t;
                res++;
            }
        }
        return res;
    }
}