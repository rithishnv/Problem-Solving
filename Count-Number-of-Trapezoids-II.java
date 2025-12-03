1class Solution {
2    public int countTrapezoids(int[][] points) {
3        HashMap<Integer, HashMap<Integer, Integer>> t = new HashMap<>();
4        HashMap<Integer, HashMap<Integer, Integer>> v = new HashMap<>();
5
6        int n = points.length;
7
8        for (int i = 0; i < n; i++) {
9            for (int j = i + 1; j < n; j++) {
10
11                int dx = points[j][0] - points[i][0];
12                int dy = points[j][1] - points[i][1];
13
14                if (dx < 0 || (dx == 0 && dy < 0)) {
15                    dx = -dx;
16                    dy = -dy;
17                }
18
19                int g = gcd(dx, Math.abs(dy));
20                int sx = dx / g;
21                int sy = dy / g;
22
23                int des = sx * points[i][1] - sy * points[i][0];
24
25                int key1 = (sx << 12) | (sy + 2000);
26                int key2 = (dx << 12) | (dy + 2000);
27
28                t.computeIfAbsent(key1, k -> new HashMap<>()).merge(des, 1, Integer::sum);
29                v.computeIfAbsent(key2, k -> new HashMap<>()).merge(des, 1, Integer::sum);
30            }
31        }
32
33        return count(t) - count(v) / 2;
34    }
35
36    private int count(HashMap<Integer, HashMap<Integer, Integer>> map) {
37        long ans = 0;
38
39        for (HashMap<Integer, Integer> inner : map.values()) {
40            long sum = 0;
41
42            for (int val : inner.values()) sum += val;
43
44            for (int val : inner.values()) {
45                sum -= val;
46                ans += (long) val * sum;
47            }
48        }
49
50        return (int) ans;
51    }
52
53    private int gcd(int a, int b) {
54        while (b != 0) {
55            int t = a % b;
56            a = b;
57            b = t;
58        }
59        return Math.abs(a);
60    }
61}