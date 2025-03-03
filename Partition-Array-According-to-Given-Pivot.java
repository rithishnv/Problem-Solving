class Solution {
    public int[] pivotArray(int[] arr, int pivot) {
        int n=arr.length;
        int[] nums=new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            if(arr[i]<pivot){
                nums[j++]=arr[i];
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]==pivot){
                nums[j++]=arr[i];
            }
        }
         for(int i=0;i<n;i++){
            if(arr[i]>pivot){
                nums[j++]=arr[i];
            }
        }
        return nums;
    }
}