1class Solution {
2    public int longestBalanced(String s) {
3        int[] arr=new int[26];
4        int n=s.length();
5        int res=0;
6        Set<Integer> set=new HashSet<>();
7        for(int i=0;i<n;i++){
8            arr=new int[26];
9            for(int j=i;j<n;j++){
10                arr[s.charAt(j)-'a']++;
11                set.clear();
12                for(int a:arr){
13                    if(a!=0)
14                    set.add(a);
15                }
16                if(set.size()==1){
17                    res=Math.max(j-i+1,res);
18                }
19                
20            }
21            if(set.size()==1){
22                    res=Math.max(n-i,res);
23                }
24
25        }
26        return res;
27    }
28}