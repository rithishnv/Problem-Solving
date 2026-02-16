1class Solution {
2    public int reverseBits(int n) {
3        StringBuilder sb=new StringBuilder();
4        int t=32;
5        while(n>0){
6            sb.append(n%2);
7            n/=2;
8            t--;
9        }
10        while(t-->0){
11            sb.append('0');
12        }
13        return Integer.parseInt(sb.toString(),2);
14    }
15}