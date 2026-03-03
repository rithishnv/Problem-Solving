1class Solution {
2    public char findKthBit(int n, int k) {
3        StringBuilder sb=new StringBuilder("0");
4        int i=1;
5        while(i++<n){
6            StringBuilder sb1=new StringBuilder(sb).reverse();
7            for (int j = 0; j < sb1.length(); j++) {
8                sb1.setCharAt(j, sb1.charAt(j) == '0' ? '1' : '0');
9            }
10            sb.append("1");
11            sb.append(sb1);
12        }
13        return sb.charAt(k-1);
14    }
15}