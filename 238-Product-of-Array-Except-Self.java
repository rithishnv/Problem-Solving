class Solution {
    public int[] productExceptSelf(int[] nums) {
        int m=1,f=0;
        for(int i:nums){
            if(i==0){
                f++;
                continue;
            }
            m*=i;
        }
        if(f>=2)
        return new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
            nums[i]=m;
            else if(f==1)
            nums[i]=0;
            else
            nums[i]=m/nums[i];
        }
        return nums;
    }
}