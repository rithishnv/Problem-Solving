1class Solution {
2    public int maximumAmount(int[][] coins) {
3        int m = coins.length, n = coins[0].length;
4
5        int[][][] dp = new int[m][n][3];
6
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
10            }
11        }
12
13        dp[0][0][0] = coins[0][0];
14        if (coins[0][0] < 0) {
15            dp[0][0][1] = 0;
16        }
17
18        for (int i = 0; i < m; i++) {
19            for (int j = 0; j < n; j++) {
20                if (i == 0 && j == 0) {
21                    continue;
22                }
23                for (int used = 0; used < 3; used++) {
24                    int best = Integer.MIN_VALUE;
25                    
26                    if (i > 0) {
27                        if (dp[i-1][j][used] != Integer.MIN_VALUE) {
28                            int val = dp[i-1][j][used] + coins[i][j];
29                            best = Math.max(best, val);
30                        }
31                        if (used > 0 && coins[i][j] < 0) {
32                            if (dp[i-1][j][used-1] != Integer.MIN_VALUE) {
33                                int val = dp[i-1][j][used-1] + 0;
34                                best = Math.max(best, val);
35                            }
36                        }
37                    }
38                    
39                    if (j > 0) {
40                        if (dp[i][j-1][used] != Integer.MIN_VALUE) {
41                            int val = dp[i][j-1][used] + coins[i][j];
42                            best = Math.max(best, val);
43                        }
44                        if (used > 0 && coins[i][j] < 0) {
45                            if (dp[i][j-1][used-1] != Integer.MIN_VALUE) {
46                                int val = dp[i][j-1][used-1] + 0;
47                                best = Math.max(best, val);
48                            }
49                        }
50                    }
51                    
52                    dp[i][j][used] = best;
53                }
54            }
55        }
56
57        return Math.max(dp[m-1][n-1][0], Math.max(dp[m-1][n-1][1], dp[m-1][n-1][2]));
58    }
59}