1class Solution {
2    public int zigZagArrays(int n, int l, int r) {
3        int m = r - l + 1;
4        int[] dp = new int[m];
5        Arrays.fill(dp, 1);
6        int MOD = 1000000007;
7        for (int i = 2; i <= n; i++) {
8            int sum = 0;
9            if (i%2==0)
10                for (int j = 0; j < m; j++) {
11                    int t = dp[j];
12                    dp[j] = sum;
13                    sum = (sum + t) % MOD;
14                }
15            else
16                for (int j = m - 1; j >= 0; j--) {
17                    int t = dp[j];
18                    dp[j] = sum;
19                    sum = (sum + t) % MOD;
20                }
21        }
22
23        int res = 0;
24        for (int j = 0; j < m; j++)
25            res = (res + dp[j]) % MOD;
26
27        return (res*2) % MOD;
28    }
29}