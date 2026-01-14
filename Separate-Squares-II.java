1class Solution {
2    static class Event {
3        double y, x1, x2;
4        int type;
5        Event(double y, double x1, double x2, int type) {
6            this.y = y; this.x1 = x1; this.x2 = x2; this.type = type;
7        }
8    }
9
10    double[] xs, seg;
11    int[] cnt;
12
13    void update(int node, int l, int r, int ql, int qr, int val) {
14        if (qr <= l || r <= ql) return;
15        if (ql <= l && r <= qr) cnt[node] += val;
16        else {
17            int m = (l + r) / 2;
18            update(node*2, l, m, ql, qr, val);
19            update(node*2+1, m, r, ql, qr, val);
20        }
21
22        if (cnt[node] > 0) seg[node] = xs[r] - xs[l];
23        else if (r - l == 1) seg[node] = 0;
24        else seg[node] = seg[node*2] + seg[node*2+1];
25    }
26
27    public double separateSquares(int[][] squares) {
28        ArrayList<Double> list = new ArrayList<>();
29        for (int[] s : squares) {
30            list.add((double)s[0]);
31            list.add(s[0] + s[2] * 1.0);
32        }
33        xs = list.stream().distinct().sorted().mapToDouble(d -> d).toArray();
34
35        ArrayList<Event> events = new ArrayList<>();
36        for (int[] s : squares) {
37            events.add(new Event(s[1], s[0], s[0]+s[2], 1));
38            events.add(new Event(s[1]+s[2], s[0], s[0]+s[2], -1));
39        }
40        events.sort((a,b) -> Double.compare(a.y, b.y));
41
42        int n = xs.length;
43        cnt = new int[4*n];
44        seg = new double[4*n];
45
46        double total = 0, prevY = events.get(0).y;
47        ArrayList<double[]> strips = new ArrayList<>();
48
49        for (Event e : events) {
50            if (e.y > prevY) {
51                double h = e.y - prevY;
52                double w = seg[1];
53                total += w * h;
54                strips.add(new double[]{prevY, h, w});
55                prevY = e.y;
56            }
57            int l = Arrays.binarySearch(xs, e.x1);
58            int r = Arrays.binarySearch(xs, e.x2);
59            update(1, 0, n-1, l, r, e.type);
60        }
61
62        double half = total / 2, acc = 0;
63        for (double[] s : strips) {
64            if (acc + s[1]*s[2] >= half)
65                return s[0] + (half - acc) / s[2];
66            acc += s[1] * s[2];
67        }
68        return 0;
69    }
70}