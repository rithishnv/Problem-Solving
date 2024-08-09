class Solution {
    public boolean check(int[][] grid, int r, int c) {
        if (r + 2 >= grid.length || c + 2 >= grid[0].length) {
            return false;
        }
        if (grid[r + 1][c + 1] != 5)
            return false;
        List<Integer> li = new ArrayList<>();
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (!li.contains(grid[i][j]) && grid[i][j] != 0 && grid[i][j] <= 9) {
                    li.add(grid[i][j]);
                } else
                    return false;
            }
        }
        return sumCheck(grid, r, c);
    }

    public boolean sumCheck(int[][] grid, int r, int c) {
        int[] csum = new int[3];
        for (int i = r; i < r + 3; i++) {
            int rsum = 0;
            for (int j = c; j < c + 3; j++) {
                rsum += grid[i][j];
                csum[j - c] += grid[i][j];
            }
            if (rsum != 15)
                return false;
        }
        for (int i : csum)
            if (i != 15)
                return false;
        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int r = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (check(grid, i, j)) {
                    j += 1;
                    r++;
                }
            }
        }
        return r;
    }
}