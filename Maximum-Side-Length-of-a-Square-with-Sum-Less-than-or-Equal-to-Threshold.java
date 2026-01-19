1class Solution {
2    public int maxSideLength(int[][] mat, int threshold) {
3        int m = mat.length, n = mat[0].length;
4        int[][] pre = new int[m + 1][n + 1];
5
6        for (int i = 1; i <= m; i++) {
7            for (int j = 1; j <= n; j++) {
8                pre[i][j] = mat[i - 1][j - 1]
9                          + pre[i - 1][j]
10                          + pre[i][j - 1]
11                          - pre[i - 1][j - 1];
12            }
13        }
14
15        int left = 0, right = Math.min(m, n), ans = 0;
16
17        while (left <= right) {
18            int mid = (left + right) / 2;
19            boolean found = false;
20
21            for (int i = mid; i <= m && !found; i++) {
22                for (int j = mid; j <= n; j++) {
23                    int sum = pre[i][j]
24                            - pre[i - mid][j]
25                            - pre[i][j - mid]
26                            + pre[i - mid][j - mid];
27
28                    if (sum <= threshold) {
29                        found = true;
30                        break;
31                    }
32                }
33            }
34            if (found) {
35                ans = mid;
36                left = mid + 1;
37            } else {
38                right = mid - 1;
39            }
40        }
41        return ans;
42    }
43}