class Solution {
    public int sum(int[] nums,int ind,int n,int s){
        if(ind==n)
        return s;
        int a=sum(nums,ind+1,n,s^nums[ind]);
        int b=sum(nums,ind+1,n,s);
        return a+b;
    }
    public int subsetXORSum(int[] nums) {
       return sum(nums,0,nums.length,0);
    }
}