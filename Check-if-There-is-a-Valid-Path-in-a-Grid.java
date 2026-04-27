1import java.util.*;
2
3class Solution {
4
5    List<int[][]> dirs = Arrays.asList(
6        new int[][]{},                         
7        new int[][]{{0, -1}, {0, 1}},           
8        new int[][]{{-1, 0}, {1, 0}},           
9        new int[][]{{0, -1}, {1, 0}},           
10        new int[][]{{0, 1}, {1, 0}},            
11        new int[][]{{0, -1}, {-1, 0}},          
12        new int[][]{{-1, 0}, {0, 1}}            
13    );
14
15    public boolean dfs(int x, int y, boolean[][] vis, int[][] grid) {
16        vis[x][y] = true;
17        int m = grid.length, n = grid[0].length;
18
19        if (x == m - 1 && y == n - 1)
20            return true;
21
22        for (int[] d : dirs.get(grid[x][y])) {
23            int nx = x + d[0];
24            int ny = y + d[1];
25
26            if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny])
27                continue;
28
29            int[][] nextDir = dirs.get(grid[nx][ny]);
30            boolean connected = false;
31
32            for (int[] nd : nextDir) {
33                if (nx + nd[0] == x && ny + nd[1] == y) {
34                    connected = true;
35                    break;
36                }
37            }
38
39            if (!connected)
40                continue;
41
42            if (dfs(nx, ny, vis, grid))
43                return true;
44        }
45        return false;
46    }
47
48    public boolean hasValidPath(int[][] grid) {
49        int m = grid.length, n = grid[0].length;
50        boolean[][] vis = new boolean[m][n];
51        return dfs(0, 0, vis, grid);
52    }
53}