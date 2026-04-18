1class Solution {
2    public int mirrorDistance(int n) {
3        int a=n;
4        int b=0;
5        while(a>0){
6            b=(b*10)+a%10;
7            a/=10;
8        }
9        return Math.abs(n-b);
10    }
11}