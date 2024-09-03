class Solution {
    int[] a=new int[]{-1,-1};
    public int[] search(int[] nums,int l,int h,int target){
        if(l<h){
            int m=l+(h-l)/2;
            if(nums[m]==target){
                int i=m,j=m;
                while(i>-1 && nums[i]==target)
                i--;
                while(j<nums.length&&nums[j]==target)
                j++;
                a[0]=i+1;
                a[1]=j-1;
                return a;
            }
            else if(nums[m]>target)
            search(nums,l,m,target);
            else
             search(nums,m+1,h,target);
        }
        return a;
    }
    public int[] searchRange(int[] nums, int target) {
        return search(nums,0,nums.length,target);
    }
}