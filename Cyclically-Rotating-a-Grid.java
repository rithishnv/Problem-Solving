1class Solution {
2    public int[][] rotateGrid(int[][] grid, int k) {
3
4        int m = grid.length;
5        int n = grid[0].length;
6
7        int layers = Math.min(m, n) / 2;
8
9        for (int layer = 0; layer < layers; layer++) {
10
11            ArrayList<Integer> nums = new ArrayList<>();
12
13            int top = layer;
14            int bottom = m - layer - 1;
15            int left = layer;
16            int right = n - layer - 1;
17
18            for (int j = left; j <= right; j++) {
19                nums.add(grid[top][j]);
20            }
21
22            for (int i = top + 1; i <= bottom - 1; i++) {
23                nums.add(grid[i][right]);
24            }
25
26            for (int j = right; j >= left; j--) {
27                nums.add(grid[bottom][j]);
28            }
29
30            for (int i = bottom - 1; i >= top + 1; i--) {
31                nums.add(grid[i][left]);
32            }
33
34            int len = nums.size();
35
36            int rotate = k % len;
37
38            int[] rotated = new int[len];
39
40            for (int i = 0; i < len; i++) {
41                rotated[i] = nums.get((i + rotate) % len);
42            }
43
44            int idx = 0;
45
46            for (int j = left; j <= right; j++) {
47                grid[top][j] = rotated[idx++];
48            }
49
50            for (int i = top + 1; i <= bottom - 1; i++) {
51                grid[i][right] = rotated[idx++];
52            }
53
54            for (int j = right; j >= left; j--) {
55                grid[bottom][j] = rotated[idx++];
56            }
57
58            for (int i = bottom - 1; i >= top + 1; i--) {
59                grid[i][left] = rotated[idx++];
60            }
61        }
62
63        return grid;
64    }
65}