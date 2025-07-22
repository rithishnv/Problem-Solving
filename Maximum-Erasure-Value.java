class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i=0,j=0;
        int n=nums.length;
        int[] arr=new int[10001];
        int max=0,t=0;
        while(i<n){
             while(j<n && arr[nums[i]]==1){
                t-=nums[j];
                arr[nums[j]]--;
                j++;
            }
                t+=nums[i];
                arr[nums[i]]++;
                i++;
                max=Math.max(t,max);
        }
        return max;
    }
}