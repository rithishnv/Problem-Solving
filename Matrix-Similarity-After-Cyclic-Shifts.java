1class Solution {
2    public boolean areSimilar(int[][] mat, int k) {
3        int m = mat.length, n = mat[0].length;
4
5        for (int i = 0; i < m; i++) {
6            for (int j = 0; j < n; j++) {
7                if (i % 2 == 0) {
8                    if (mat[i][j] != mat[i][(j - k % n + n) % n]) {
9                        return false;
10                    }
11                } else {
12                    if (mat[i][j] != mat[i][(j + k % n) % n]) {
13                        return false;
14                    }
15                }
16            }
17        }
18
19        return true;
20    }
21}