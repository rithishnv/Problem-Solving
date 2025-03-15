class Solution {
    public int minCapability(int[] nums, int k) {
        int l=Integer.MAX_VALUE,r=Integer.MIN_VALUE;
        for(int i:nums){
            l=Math.min(l,i);
            r=Math.max(r,i);
        }
        while(l<r){
            int m=l+(r-l)/2;
            if(isValid(nums,k,m)){
                r=m;
            }
            else
            l=m+1;
        }
        return l;
    }
    boolean isValid(int[] nums,int k,int v){
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=v){
            c++;
            i++;
            }
            if(c>=k)
            return true;
        }
        return c>=k;
    }
}