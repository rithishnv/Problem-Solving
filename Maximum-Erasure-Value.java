class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i=0,j=0;
        int n=nums.length;
        boolean[] arr=new boolean[10001];
        int max=0,t=0;
        while(i<n){
             while(j<n && arr[nums[i]]){
                t-=nums[j];
                arr[nums[j]]=false;
                j++;
            }
                t+=nums[i];
                arr[nums[i]]=true;
                i++;
                max=Math.max(t,max);
        }
        return max;
    }
}