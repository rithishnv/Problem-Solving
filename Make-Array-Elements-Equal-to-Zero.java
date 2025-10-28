class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        arr[0]=nums[0];
        for(int i=1;i<n;i++){
            arr[i]=arr[i-1]+nums[i];
        }
        int res=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                if(arr[i]*2==arr[n-1]){
                    res+=2;
                }
                else if(Math.abs(arr[i]*2-arr[n-1])==1){
                    res+=1;
                }
            }
        }
        return res;
    }
}