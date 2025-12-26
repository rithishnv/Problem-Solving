1class Solution {
2    public int bestClosingTime(String customers) {
3        int n=customers.length();
4        int min=n;
5        int res=n;
6        int r=0,e=0;
7        int[] arr=new int[n+1];
8        for(int i=0;i<n;i++){
9            e+=(customers.charAt(i)=='N')?1:0;
10            r+=(customers.charAt(n-i-1)=='Y')?1:0;
11            arr[i]+=e;
12            arr[n-i-1]+=r;
13        }
14        arr[n]=e;
15        for(int i=0;i<customers.length();i++){
16           arr[i]+=(customers.charAt(i)=='N')?-1:0;
17           if(arr[i]<min){
18            min=arr[i];
19            res=i;
20           }
21        }
22        if(arr[n]<min){
23            min=arr[n];
24            res=n;
25           }
26        return res;
27    }
28}