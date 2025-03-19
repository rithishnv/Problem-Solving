class Solution {
    int flip(int[] nums,int i){
        return (nums[i]==1)?0:1;
    }
    public int minOperations(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]==0){
                c++;
                nums[i]=1;
                nums[i+1]=flip(nums,i+1);
                nums[i+2]=flip(nums,i+2);
            }
        }
        int n=nums.length;
        return (nums[n-1]==1 && nums[n-2]==1)?c:-1;
    }
}