1class Solution {
2    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
3        Arrays.sort(arr);
4        int n=arr.length;
5        arr[0]=1;
6        for(int i=1;i<n;i++){
7            if(arr[i]-arr[i-1]>1){
8                arr[i]=arr[i-1]+1;
9            }
10        }
11        return arr[n-1];
12    }
13}