class Solution {
    public int maximumCount(int[] nums) {
        int n=nums.length;
        int i=0,j=n-1,res=-1;
        if(nums[0] <0 && nums[n-1]<0)return n;
        if(nums[0] >0 && nums[n-1]>0)return n;
        while(i<j){
            int m=i+(j-i)/2;
            if(nums[m]>0){
                j=m;
            }
            else
            i=m+1;
        }
        int p=(i==n-1)?0:n-i;
        i=0;
        j=n-1;
         while(i<j){
            int m=i+(j-i)/2;
            if(nums[m]<0){
                i=m+1;
            }
            else
            j=m;
        }
        int neg=(j==0 && nums[j]<0)?1:j;
        return Math.max(p,neg);
    }
}