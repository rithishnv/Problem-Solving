class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];
        pq.add(new int[]{grid[0][0],0,0});
        visited[0][0] = true;
        int res = 0;
        while(pq.size() > 0){
            int[] top = pq.poll();
            res = Math.max(res,top[0]);
            if(top[1] == n-1 && top[2] == n-1) break;
            for(int k = 0; k < 4; k ++){
                int nx = top[1] + dir[k][0];
                int ny = top[2] + dir[k][1];
                if(nx >= 0 && nx < n && ny >=0 && ny < n && !visited[nx][ny]){
                    pq.add(new int[]{grid[nx][ny],nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return res;
    }
}