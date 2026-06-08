1class Solution {
2    public int[] pivotArray(int[] arr, int pivot) {
3        int n=arr.length;
4        int[] nums=new int[n];
5        int j=0;
6        for(int i=0;i<n;i++){
7            if(arr[i]<pivot){
8                nums[j++]=arr[i];
9            }
10        }
11        for(int i=0;i<n;i++){
12            if(arr[i]==pivot){
13                nums[j++]=arr[i];
14            }
15        }
16         for(int i=0;i<n;i++){
17            if(arr[i]>pivot){
18                nums[j++]=arr[i];
19            }
20        }
21        return nums;
22    }
23}