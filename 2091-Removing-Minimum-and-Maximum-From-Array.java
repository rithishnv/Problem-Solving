class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int mini=-1,maxi=-1;
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]<min){
                min=nums[i];
                mini=i;
            }
            if(nums[i]>max){
                max=nums[i];
                maxi=i;
            }
        }
        int t1=Math.max(mini,maxi)+1;
        int t2=n-Math.min(mini,maxi);
        int t3=Math.min((mini+1)+(n-maxi),(n-mini)+(maxi+1));
        return Math.min(t1,Math.min(t2,t3));
    }
}