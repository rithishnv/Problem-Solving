1class Solution {
2    public int check(int num){
3        String s=Integer.toString(num);
4        int n=s.length();
5        int c=0;
6        for(int i=1;i<n-1;i++){
7            if((s.charAt(i-1) < s.charAt(i) && s.charAt(i+1) < s.charAt(i)) ||
8            (s.charAt(i-1) > s.charAt(i) && s.charAt(i+1) > s.charAt(i))){
9                c++;
10            }
11        }
12        return c;
13
14    }
15    public int totalWaviness(int num1, int num2) {
16        int cnt=0;
17        for(int i=num1;i<=num2;i++){
18            cnt+=check(i);
19        }
20        return cnt;
21    }
22}