1class Solution {
2    public boolean check(int[][] grid, int r, int c) {
3        if (r + 2 >= grid.length || c + 2 >= grid[0].length) {
4            return false;
5        }
6        if (grid[r + 1][c + 1] != 5)
7            return false;
8        List<Integer> li = new ArrayList<>();
9        int[] csum = new int[3];
10        for (int i = r; i < r + 3; i++) {
11            int rsum = 0;
12            for (int j = c; j < c + 3; j++) {
13                if (!li.contains(grid[i][j]) && grid[i][j] != 0 && grid[i][j] <= 9) {
14                    li.add(grid[i][j]);
15                    rsum += grid[i][j];
16                    csum[j - c] += grid[i][j];
17                } else
18                    return false;
19            }
20            if (rsum != 15)
21                return false;
22        }
23        for (int i : csum)
24            if (i != 15)
25                return false;
26        return true;
27    }
28
29    public int numMagicSquaresInside(int[][] grid) {
30        int r = 0;
31        for (int i = 0; i < grid.length; i++) {
32            for (int j = 0; j < grid[0].length; j++) {
33                if (check(grid, i, j)) {
34                    j += 1;
35                    r++;
36                }
37            }
38        }
39        return r;
40    }
41}