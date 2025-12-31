1class Solution {
2    public boolean isPossible(int m, int n, int t, int[][] cells) {
3        int[][] grid = new int[m + 1][n + 1]; 
4        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
5
6        for (int i = 0; i < t; i++) {
7            grid[cells[i][0]][cells[i][1]] = 1; 
8        }
9
10        Queue<int[]> queue = new LinkedList<>();
11        
12        for (int i = 1; i <= n; i++) {
13            if (grid[1][i] == 0) {
14                queue.offer(new int[]{1, i}); 
15                grid[1][i] = 1; 
16            }
17        }
18        
19        while (!queue.isEmpty()) {
20            int[] cell = queue.poll();
21            int r = cell[0], c = cell[1]; 
22            
23            for (int[] dir : directions) {
24                int nr = r + dir[0], nc = c + dir[1]; 
25                
26                if (nr > 0 && nc > 0 && nr <= m && nc <= n && grid[nr][nc] == 0) {
27                    grid[nr][nc] = 1; 
28                    
29                    if (nr == m) {
30                        return true; 
31                    }
32                    
33                    queue.offer(new int[]{nr, nc}); 
34                }
35            }
36        }
37        
38        return false;
39    }
40
41    public int latestDayToCross(int row, int col, int[][] cells) {
42        int left = 0, right = row * col, latestPossibleDay = 0;
43        
44        while (left < right - 1) {
45            int mid = left + (right - left) / 2;
46            
47            if (isPossible(row, col, mid, cells)) {
48                left = mid;
49                latestPossibleDay = mid; 
50            } else {
51                right = mid; 
52            }
53        }
54        
55        return latestPossibleDay;
56    }
57}