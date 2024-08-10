class Solution {
    public int dfs(int[][] g,int r,int c){
        if(Math.min(r, c) < 0 || Math.max(r, c) >= g.length || g[r][c] != 0)
        return 0;
        g[r][c]=1;
        return 1+dfs(g,r+1,c)+dfs(g,r-1,c)+dfs(g,r,c+1)+dfs(g,r,c-1);
    }
    public int regionsBySlashes(String[] grid) {
        int r=0,n=grid.length;
        int[][] g=new int[n*3][n*3];
        for(int i=0;i<n;i++){
            for(int j=0;j<grid[0].length();j++){
                if(grid[i].charAt(j)=='/'){
                g[i*3][j*3+2]=1;
                g[i*3+1][j*3+1]=1;
                g[i*3+2][j*3]=1;
            }
            else if(grid[i].charAt(j)=='\\'){
                g[i*3][j*3]=1;
                g[i*3+1][j*3+1]=1;
                g[i*3+2][j*3+2]=1;
            }
            }
        }
        for(int i=0;i<n*3;i++){
            for(int j=0;j<n*3;j++){
            r+=(dfs(g,i,j)>0)?1:0;
            }
        }
        return r;
    }
}