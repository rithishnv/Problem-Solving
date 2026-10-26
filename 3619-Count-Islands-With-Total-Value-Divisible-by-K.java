class Solution {
    public int countIslands(int[][] grid, int k) {
        int res=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    continue;
                }
                if(dfs(grid,i,j,n,m)%k==0){
                    res++;
                }
            }
        }
        return res;
    }
    public long dfs(int[][] grid,int i,int j,int n,int m){
        long t=0;
        if(i<0 || j<0 || i>=n || j>=m ||grid[i][j]==0){
            return 0;
        }
        t+=grid[i][j];
        grid[i][j]=0;
        t+=dfs(grid,i+1,j,n,m);
        t+=dfs(grid,i-1,j,n,m);
        t+=dfs(grid,i,j+1,n,m);
        t+=dfs(grid,i,j-1,n,m);
        return t;
    }
}