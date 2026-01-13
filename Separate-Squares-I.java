1class Solution {
2    public double separateSquares(int[][] squares) {
3        double totalArea = 0;
4        double low = 1e18, high = -1e18;
5
6        for (int[] s : squares) {
7            double y = s[1], l = s[2];
8            totalArea += l * l;
9            low = Math.min(low, y);
10            high = Math.max(high, y + l);
11        }
12
13        for (int i = 0; i < 80; i++) {
14            double mid = (low + high) / 2.0;
15            double areaBelow = 0;
16
17            for (int[] s : squares) {
18                double y = s[1], l = s[2];
19                if (mid <= y) continue;
20                if (mid >= y + l) areaBelow += l * l;
21                else areaBelow += l * (mid - y);
22            }
23
24            if (areaBelow * 2 < totalArea)
25                low = mid;
26            else
27                high = mid;
28        }
29        return low;
30    }
31}