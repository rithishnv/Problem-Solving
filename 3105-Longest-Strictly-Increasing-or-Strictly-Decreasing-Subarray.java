class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int m1=1,m2=1,t1=1,t2=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
            t1++;
            m1=Math.max(t1,m1);
            t2=1;
            }
            else if(nums[i]<nums[i+1]){
                t2++;
                m2=Math.max(t2,m2);
                t1=1;
            }
            else{
                t1=1;
                t2=1;
            }
        }
        return Math.max(m1,m2);
    }
}