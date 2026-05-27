1class Solution {
2    public int numberOfSpecialChars(String word) {
3        int n=word.length();
4        int res=0;
5        int[] arr=new int[26];
6        int[] arr1=new int[26];
7        int j=0;
8        Arrays.fill(arr,-1);
9        Arrays.fill(arr1,n);
10        for(char i:word.toCharArray()){
11            if(i>='a'){
12                arr[i-'a']=j;
13            }
14            else if(arr1[i-'A']==n){
15                arr1[i-'A']=j;
16            }
17            j++;
18        }
19        for(int i=0;i<26;i++){
20            if(arr[i]!=-1 && arr1[i]!=n && arr[i]<arr1[i]){
21                res++;
22            }
23        }
24        return res;
25    }
26}