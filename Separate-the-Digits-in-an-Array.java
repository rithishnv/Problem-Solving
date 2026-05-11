1class Solution {
2    public int[] separateDigits(int[] nums) {
3        StringBuilder sb=new StringBuilder();
4        for(int i:nums){
5            sb.append(i);
6        }
7        int n=sb.length();
8        int[] res=new int[n];
9        for(int i=0;i<n;i++){
10            res[i]=sb.charAt(i)-'0';
11        }
12        return res;
13    }
14}