1class Solution {
2        public int[] minBitwiseArray(List<Integer> A) {
3        int n = A.size(), res[] = new int[n];
4        for (int i = 0; i < n; i++) {
5            int a = A.get(i);
6            if (A.get(i) % 2 == 0) {
7                res[i] = -1;
8            } else {
9                res[i] = a - ((a + 1) & (-a - 1)) / 2;
10            }
11        }
12        return res;
13    }
14}