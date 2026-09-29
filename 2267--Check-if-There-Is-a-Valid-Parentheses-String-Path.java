class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int len = m + n - 1;

        if (len % 2 == 1 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {
                0, 0, 1
        });

        boolean[][][] visited = new boolean[m][n][len + 1];
        visited[0][0][1] = true;

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();

            int row = curr[0];
            int col = curr[1];
            int balance = curr[2];

            if (row == m - 1 && col == n - 1) {
                return balance == 0;
            }

            if (row + 1 < m) {
                int newBal = balance + (grid[row + 1][col] == '(' ? 1 : -1);

                if (newBal >= 0 && newBal <= len - row - col - 2 && !visited[row + 1][col][newBal]) {
                    visited[row + 1][col][newBal] = true;
                    stack.push(new int[] {
                            row + 1, col, newBal
                    });
                }
            }

            if (col + 1 < n) {
                int newBal = balance + (grid[row][col + 1] == '(' ? 1 : -1);

                if (newBal >= 0 && newBal <= len - row - col - 2 && !visited[row][col + 1][newBal]) {
                    visited[row][col + 1][newBal] = true;
                    stack.push(new int[] {
                            row, col + 1, newBal
                    });
                }
            }
        }

        return false;
    }
}