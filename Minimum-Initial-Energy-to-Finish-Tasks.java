1class Solution {
2    public int minimumEffort(int[][] tasks) {
3        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
4        int ans = 0;
5        int energy = 0;
6        for (int i = 0; i < tasks.length; i++) {
7            int actual = tasks[i][0];
8            int minimum = tasks[i][1];
9            if (energy < minimum) {
10                ans += (minimum - energy);
11                energy = minimum;
12            } 
13            energy -= actual;
14        }
15        return ans;
16    }
17}