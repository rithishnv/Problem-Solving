class Solution {
    public int missingInteger(int[] nums) {
        int sum=nums[0];
        int i=1,n=nums.length;
        int[] arr=new int[51];
        while(i<n && nums[i]-1==nums[i-1]){
            sum+=nums[i];
            i++;
        }
        i=0;
        while(i<n){
            arr[nums[i]]++;
            i++;
        }
        while(sum<=50 && arr[sum]!=0){
            sum+=1;
        }
        return sum;
    }
}