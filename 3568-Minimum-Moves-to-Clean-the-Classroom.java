class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int litterCount = 0;
        int sr = 0, sc = 0;
        int[][] litterId = new int[m][n];
        for (int[] row : litterId){ 
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    sr = i;
                    sc = j;
                } else if (c == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }
        int fullMask = (1 << litterCount) - 1;
        if (litterCount == 0){
             return 0;
        }
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << litterCount];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc, energy, 0});
        visited[sr][sc][energy][0] = true;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                int e = cur[2];
                int mask = cur[3];
                if (mask == fullMask){
                     return moves;
                }
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n){
                         continue;
                    }
                    if (classroom[nr].charAt(nc) == 'X'){
                         continue;
                    }
                    if (e == 0 && classroom[r].charAt(c) != 'R'){
                         continue;
                    }
                    int ne = e - 1;
                    int nmask = mask;
                    if (litterId[nr][nc] != -1) {
                        nmask |= 1 << litterId[nr][nc];
                    }
                    if (classroom[nr].charAt(nc) == 'R') {
                        ne = energy;
                    }
                    if (!visited[nr][nc][ne][nmask]) {
                        visited[nr][nc][ne][nmask] = true;
                        queue.offer(new int[]{nr, nc, ne, nmask});
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}