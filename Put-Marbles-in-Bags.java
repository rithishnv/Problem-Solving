class Solution {
    public long putMarbles(int[] weights, int k) {
        int n=weights.length; 
        int[] arr=new int[n-1];
        for(int i=0;i<n-1;i++){
            arr[i]=(weights[i]+weights[i+1]);
        }
        long sum=0;
        Arrays.sort(arr);
        for(int i=0;i<k-1;i++){
            sum+=arr[n-i-2]-arr[i];
        }
        return sum;
    }
}