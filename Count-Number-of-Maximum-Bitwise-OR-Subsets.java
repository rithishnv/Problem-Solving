class Solution {
    int c=0;
    public void check(int[] nums,int i,int or,int max){
        if(or==max)
        c++;
        for(int j=i;j<nums.length;j++){
            check(nums,j+1,or|nums[j],max);
        }
    }
    public int countMaxOrSubsets(int[] nums) {
        int or=nums[0];
        int max=0;
        for(int i=0;i<nums.length;i++){
            max|=nums[i];
        }
        check(nums,0,0,max);
        return (c);
    }
}