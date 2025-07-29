class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        // int max=0;
        int[] last=new int[32];
        // int[] arr=new int[n];
       for(int i=n-1;i>-1;i--){
        int r=i;
        for(int j=0;j<32;j++){
            if((nums[i] & (1<<j)) !=0)
            last[j]=i;
            else
            r=Math.max(r,last[j]);
        }
        nums[i]=r-i+1;
       }
        return nums;
    }
}