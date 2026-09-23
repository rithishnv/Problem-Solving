class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        long sum=0;
        for(int num:nums){
            sum+=num;
        }
        long target=sum-x;
        if(target<0){
            return -1;
        }
        if(target==0){
            return n;
        }
        int low=0;
        int windowsum=0;
        int len=-1;
        for(int high=0;high<n;high++){
            windowsum+=nums[high];
            while(low<=high && windowsum>target){
                windowsum-=nums[low];
                low++;
            }
            if(windowsum==target){
                len=Math.max(len,high-low+1);
            }
        }
        return (len==-1)?-1:n-len;
    }
}