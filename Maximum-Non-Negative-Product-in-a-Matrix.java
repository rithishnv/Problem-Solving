1class Solution {
2    int mod = 1000000007;
3    long product = -1;
4    
5    public int maxProductPath(int[][] grid) {
6        dfs(grid,0,0,grid[0][0]);    
7        return (int)(product%mod);
8    }
9    
10    public void dfs(int[][] grid, int i, int j, long curr){
11        if(i==grid.length-1 && j==grid[0].length-1){
12            product=Math.max(product,curr);
13            return;
14        }
15        if(grid[i][j]==0){
16            product=Math.max(product,0);
17            return;
18        }
19        if(i+1<grid.length)
20            dfs(grid,i+1,j,curr*grid[i+1][j]);
21        if(j+1<grid[0].length)
22            dfs(grid,i,j+1,curr*grid[i][j+1]);
23    }
24}