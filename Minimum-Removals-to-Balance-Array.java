1class Solution {
2     public int minRemoval(int[] A, int k) {
3        Arrays.sort(A);
4        int i = 0;
5        for (int a: A)
6            if (a > 1L * A[i] * k)
7                ++i;
8        return i;
9    }
10}