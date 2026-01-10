1class Solution {
2    public int minimumDeleteSum(String s1, String s2) {
3        int tot=0,n1=s1.length(),n2=s2.length();
4        for(char i:s1.toCharArray())
5        tot+=i;
6        for(char i:s2.toCharArray())
7        tot+=i;
8        int[][] dp=new int[n1+1][n2+1];
9        for(int i=1;i<=n1;i++){
10            for(int j=1;j<=n2;j++){
11                if(s1.charAt(i-1)==s2.charAt(j-1))
12                dp[i][j]+=dp[i-1][j-1]+s1.charAt(i-1);
13                else
14                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
15            }
16        }
17        return tot-2*dp[n1][n2];
18    }
19}