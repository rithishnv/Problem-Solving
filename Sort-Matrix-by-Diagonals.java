class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> diagonal = new ArrayList<>();
            int x = i, y = 0;
            while (x < n && y < n) {
                diagonal.add(grid[x][y]);
                x++;
                y++;
            }
            Collections.sort(diagonal, Collections.reverseOrder());
            x = i; y = 0;
            int idx = 0;
            while (x < n && y < n) {
                grid[x][y] = diagonal.get(idx++);
                x++;
                y++;
            }
        }

        for (int j = 1; j < n; j++) {
            List<Integer> diagonal = new ArrayList<>();
            int x = 0, y = j;
            while (x < n && y < n) {
                diagonal.add(grid[x][y]);
                x++;
                y++;
            }
            Collections.sort(diagonal);
            x = 0; y = j;
            int idx = 0;
            while (x < n && y < n) {
                grid[x][y] = diagonal.get(idx++);
                x++;
                y++;
            }
        }

        return grid;
    }
}