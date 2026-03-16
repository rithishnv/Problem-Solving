1class Solution {
2    public int[] getBiggestThree(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5        TreeSet<Integer> uniqueSum = new TreeSet<>();
6        for (int i = 0; i < n; i++) {
7            for (int j = 0; j < m; j++) {
8                uniqueSum.add(grid[i][j]);
9                for (int len = 1; i + 2 * len < n && j - len >= 0 && j + len < m; len++){
10                    int currentSum = 0;
11                    for (int ind = 0; ind < len; ind++)
12                        currentSum += grid[i + ind][j + ind];
13                    for (int ind = 0; ind < len; ind++)
14                        currentSum += grid[i + len + ind][j + len - ind];
15                    for (int ind = 0; ind < len; ind++)
16                        currentSum += grid[i + 2 * len - ind][j - ind];
17                    for (int ind = 0; ind < len; ind++)
18                        currentSum += grid[i + len - ind][j - len + ind];
19
20                    uniqueSum.add(currentSum);
21                }
22            }
23        }
24        int size = Math.min(3, uniqueSum.size());
25        int[] ans = new int[size];
26
27        Iterator<Integer> it = uniqueSum.descendingIterator();
28        for (int k = 0; k < size; k++) {
29            ans[k] = it.next();
30        }
31
32        return ans;
33    }
34}