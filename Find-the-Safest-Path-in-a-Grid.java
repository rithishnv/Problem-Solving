1class Solution {
2     int[] row = {0, 0, -1, 1};
3     int[] col = {-1, 1, 0, 0};
4
5    public void bfs(int[][] grid, int[][] score, int n) {
6        Queue<int[]> queue = new LinkedList<>();
7        for (int i = 0; i < n; i++) {
8            for (int j = 0; j < n; j++) {
9                if (grid[i][j] == 1) {
10                    score[i][j] = 0;
11                    queue.offer(new int[]{i, j});
12                }
13            }
14        }
15        while (!queue.isEmpty()) {
16            int[] curr = queue.poll();
17            int x = curr[0];
18            int y = curr[1];
19            int s = score[x][y];
20
21            for (int k = 0; k < 4; k++) {
22                int newX = x + row[k];
23                int newY = y + col[k];
24
25                if (newX >= 0 && newX < n && newY >= 0 && newY < n
26                        && score[newX][newY] > s + 1) {
27
28                    score[newX][newY] = s + 1;
29                    queue.offer(new int[]{newX, newY});
30                }
31            }
32        }
33    }
34
35    public int maximumSafenessFactor(List<List<Integer>> grid) {
36        int n = grid.size();
37
38        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1)
39            return 0;
40
41        int[][] score = new int[n][n];
42        for (int[] arr : score)
43            Arrays.fill(arr, Integer.MAX_VALUE);
44
45        int[][] mat = new int[n][n];
46        for (int i = 0; i < n; i++)
47            for (int j = 0; j < n; j++)
48                mat[i][j] = grid.get(i).get(j);
49
50        bfs(mat, score, n);
51
52        boolean[][] vis = new boolean[n][n];
53
54        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
55        pq.offer(new int[]{score[0][0], 0, 0});
56
57        while (!pq.isEmpty()) {
58            int[] curr = pq.poll();
59
60            int safe = curr[0];
61            int x = curr[1];
62            int y = curr[2];
63
64            if (x == n - 1 && y == n - 1)
65                return safe;
66
67            if (vis[x][y])
68                continue;
69
70            vis[x][y] = true;
71
72            for (int k = 0; k < 4; k++) {
73                int newX = x + row[k];
74                int newY = y + col[k];
75
76                if (newX >= 0 && newX < n && newY >= 0 && newY < n
77                        && !vis[newX][newY]) {
78
79                    int newSafe = Math.min(safe, score[newX][newY]);
80                    pq.offer(new int[]{newSafe, newX, newY});
81                }
82            }
83        }
84
85        return -1;
86    }
87}