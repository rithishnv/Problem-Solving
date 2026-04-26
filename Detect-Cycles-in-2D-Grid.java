1class Solution {
2    int n, m;
3    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
4    
5    public boolean containsCycle(char[][] grid) {
6        n = grid.length;
7        m = grid[0].length;
8        boolean[][] v = new boolean[n][m];
9
10        for(int i = 0; i < n; i++){
11            for(int j = 0; j < m; j++){
12                if(!v[i][j]){
13                    if(dfs(i, j, -1, -1, v, grid)){
14                        return true;
15                    }
16                }
17            }
18        }
19        return false;
20    }
21
22    public boolean dfs(int i, int j, int pi, int pj, boolean[][] v, char[][] grid){
23        v[i][j] = true;
24
25        for(int[] d : dir){
26            int x = i + d[0];
27            int y = j + d[1];
28
29            if(x < 0 || y < 0 || x >= n || y >= m) continue;
30            if(grid[x][y] != grid[i][j]) continue;
31
32            if(!v[x][y]){
33                if(dfs(x, y, i, j, v, grid)) return true;
34            } 
35            else if(x != pi || y != pj){
36                return true;
37            }
38        }
39        return false;
40    }
41}