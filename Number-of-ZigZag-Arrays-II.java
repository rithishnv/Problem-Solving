1class Solution {
2    long MOD = 1000000007;
3    public long[][] multiply(long[][] A, long[][] B) {
4        int sz = A.length;
5        long[][] C = new long[sz][sz];
6        for (int i = 0; i < sz; i++) {
7            for (int k = 0; k < sz; k++) {
8                if (A[i][k] == 0) 
9                continue;
10                long cur = A[i][k];
11                for (int j = 0; j < sz; j++) {
12                    if (B[k][j] == 0) 
13                    continue;
14                    C[i][j] = (C[i][j] + cur * B[k][j]) % MOD;
15                }
16            }
17        }
18        return C;
19    }
20
21    public int zigZagArrays(int n, int l, int r) {
22        int m = r - l + 1;
23        int sz = 2 * m;
24        long[][] T = new long[sz][sz];
25        for (int x = 0; x < m; x++) {
26            for (int y = x + 1; y < m; y++) {
27                T[x][m + y] = 1;
28            }
29            for (int y = 0; y < x; y++) {
30                T[m + x][y] = 1;
31            }
32        }
33        long[][] result = new long[sz][sz];
34        for (int i = 0; i < sz; i++) {
35            result[i][i] = 1;
36        }
37        long power = n - 1;
38        while (power > 0) {
39            if ((power & 1) == 1) {
40                result = multiply(result, T);
41            }
42            T = multiply(T, T);
43            power >>= 1;
44        }
45        long answer = 0;
46        for (int i = 0; i < sz; i++) {
47            long rowSum = 0;
48            for (int j = 0; j < sz; j++) {
49                rowSum = (rowSum + result[i][j]) % MOD;
50            }
51            answer = (answer + rowSum) % MOD;
52        }
53        return (int) answer;
54    }
55}