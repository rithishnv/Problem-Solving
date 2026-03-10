1class Solution {
2    public int numberOfStableArrays(int zero, int one, int limit) {
3        int MOD = (int)1e9 + 7;
4        
5        int[][] dp0 = new int[one + 1][zero + 1];
6        int[][] dp1 = new int[one + 1][zero + 1];
7        
8        for (int i = 1; i <= Math.min(one, limit); i++) {
9            dp1[i][0] = 1;
10        }
11        
12        for (int j = 1; j <= Math.min(zero, limit); j++) {
13            dp0[0][j] = 1;
14        }
15        
16        for (int o = 1; o <= one; o++) {
17            for (int z = 1; z <= zero; z++) {
18                if (o == 0 && z == 0) continue;
19
20                dp0[o][z] = dp1[o][z - 1];
21                dp0[o][z] = (dp0[o][z] + dp0[o][z - 1]) % MOD;
22                if (z - limit - 1 >= 0) {
23                    dp0[o][z] = (dp0[o][z] - dp1[o][z - limit - 1] + MOD) % MOD;
24                }
25
26                dp1[o][z] = dp0[o - 1][z]; 
27                dp1[o][z] = (dp1[o][z] + dp1[o - 1][z]) % MOD; 
28                if (o - limit - 1 >= 0) {
29                    dp1[o][z] = (dp1[o][z] - dp0[o - limit - 1][z] + MOD) % MOD;
30                }
31            }
32        }
33        
34        return (dp0[one][zero] + dp1[one][zero]) % MOD;
35    }
36}