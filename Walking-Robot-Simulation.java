1class Solution {
2    public int robotSim(int[] commands, int[][] obstacles) {
3        int a[] = new int[] { 0, 0 };
4        int c = 0, max = 0;
5        int[][] p = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
6        Set<String> h = new HashSet<>();
7        for (int[] i : obstacles)
8            h.add(i[0] + "," + i[1]);
9        for (int i = 0; i < commands.length; i++) {
10            if (commands[i] == -1) {
11                c = (c + 1) % 4;
12            }
13            if (commands[i] == -2) {
14                c = (c + 3) % 4;
15            }
16            for (int k = 0; k < commands[i]; k++) {
17                int x = p[c][0] + a[0];
18                int y = p[c][1] + a[1];
19                if (!h.contains(x + "," + y)) {
20                    a[0] = x;
21                    a[1] = y;
22                    max = Math.max(max, a[0] * a[0] + a[1] * a[1]);
23                } else
24                    break;
25            }
26        }
27        return max;
28    }
29}