1class Solution {
2    public int minOperations(String s, int k) {
3        int n = s.length(), zeroes = 0;
4
5        for (int i = 0; i < n; i++) {
6            if (s.charAt(i) == '0') zeroes++;
7        }
8
9        int one = n - zeroes;
10        int m = (zeroes + k - 1) / k;
11
12        while (m <= n) {
13            long total = (long)m * k;
14
15            if ((total - zeroes) % 2 != 0) {
16                m++;
17                continue;
18            }
19
20            int max_zero = 0, max_one = 0;
21            if (m % 2 == 1) {
22                max_zero = m; 
23                max_one = m - 1;   
24            } else {
25                max_zero = m - 1;   
26                max_one = m;  
27            }
28
29            long L = Math.max(zeroes, total - (long)one * max_one);
30            long R = Math.min((long)zeroes * max_zero, total);
31
32            if (L <= R) {
33                if (L % 2 == zeroes % 2 || L + 1 <= R) {
34                    return m;
35                }
36            }
37
38            m++;
39        }
40
41        return -1;
42    }
43}