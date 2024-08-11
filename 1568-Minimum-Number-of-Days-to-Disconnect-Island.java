class Solution {
    public void dfs(boolean[][] visit,int[][] grid,int i,int j){
        if(i<0 ||j<0||i==grid.length||j==grid[0].length||visit[i][j]||grid[i][j]==0)
        return;
        visit[i][j]=true;
        dfs(visit,grid,i+1,j);
        dfs(visit,grid,i,j+1);
        dfs(visit,grid,i-1,j);
        dfs(visit,grid,i,j-1);
    }
    public boolean island(int[][] grid){
        boolean c=false;
        int l=0;
        boolean[][] visit=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1) {
                l++;
            }
                if(!visit[i][j] &&grid[i][j]==1){
                if(c)
                return true;
                c=true;
                dfs(visit,grid,i,j);
                }
            }
        }
        return l==0||c==false;
    }
    public int minDays(int[][] grid) {
        if(island(grid))
        return 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                grid[i][j]=0;
                if(island(grid))
                return 1;
                grid[i][j]=1;
                }
            }
        }
        return 2;
    }
}