1class Solution {
2        public int minDeletionSize(String[] A) {
3        int res = 0, n = A.length, m = A[0].length(), i, j;
4        boolean[] sorted = new boolean[n - 1];
5        for (j = 0; j < m; ++j) {
6            for (i = 0; i < n - 1; ++i) {
7                if (!sorted[i] && A[i].charAt(j) > A[i + 1].charAt(j)) {
8                    res++;
9                    break;
10                }
11            }
12            if (i < n - 1) continue;
13            for (i = 0; i < n - 1; ++i) {
14                sorted[i] |= A[i].charAt(j) < A[i + 1].charAt(j);
15            }
16        }
17        return res;
18    }
19}