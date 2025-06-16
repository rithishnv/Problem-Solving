class Solution {
    public int maximumDifference(int[] arr) {
        int min=-1;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
            if(arr[i]<arr[j])
            min=Math.max(min,arr[j]-arr[i]);
            }
        }
        return min;
    }
}