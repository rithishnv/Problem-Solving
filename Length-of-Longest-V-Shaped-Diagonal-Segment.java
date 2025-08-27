class Solution {
    public int [][] dir = new int[][]{{1,1},{1,-1},{-1,-1},{-1,+1}};

    public int solve(int [][] grid, int i, int j,int d, boolean allowed, int target){
        int ni = i + dir[d][0];
        int nj = j + dir[d][1];
        if(ni<0 || ni>= grid.length || nj<0 || nj>= grid[ni].length || grid[ni][nj] != target){
            return 0;
        }
        int take = 1 + solve(grid, ni, nj, d,allowed,2-target);
        int notTake = 0;
        if(allowed){
            notTake = 1 + solve(grid, ni, nj, (d+1)%4, !allowed, 2-target);
        }
        return Math.max(take, notTake);
    }

    public int lenOfVDiagonal(int[][] grid) {
        int max = 0;
        for(int i  = 0; i<grid.length; i++){
            for(int j = 0;j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    for(int dir = 0; dir<4; dir++){
                        max = Math.max(max, solve(grid, i, j, (dir+1)%4, true, 2)+1);
                    }
                }
            }
        }    
        return max;
    }
}