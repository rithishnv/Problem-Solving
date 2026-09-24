class Solution {
    public int smallestIndex(int[] nums) {
        int res=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int s=0;
            while(nums[i]>0){
                s+=nums[i]%10;
                nums[i]/=10;
            }
            if(s==i){
                return i;
            }
        }
        return -1;
    }
}