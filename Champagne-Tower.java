1class Solution {
2    public double champagneTower(int poured, int query_row, int query_glass) {
3        double[] res = new double[query_row + 2];
4        res[0] = poured;
5        for (int row = 1; row <= query_row; row++)
6            for (int i = row; i >= 0; i--)
7                res[i + 1] += res[i] = Math.max(0.0, (res[i] - 1) / 2);
8        return Math.min(res[query_glass], 1.0);
9    }
10}