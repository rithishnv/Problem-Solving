1class Solution {
2    public double separateSquares(int[][] sq) {
3        double area = 0.0;
4        int n=sq.length;
5        double start = (double)sq[0][1];
6        double end = (double)sq[0][1];
7        for(int i=0; i<n; i++) {
8            area+=(double)sq[i][2]*sq[i][2];
9            start = Math.min(start,(double)sq[i][1]);
10            end = Math.max(end,(double)sq[i][1] + sq[i][2]);
11        }
12        double reqarea = area/2;
13        double farea=0;
14        for(int k = 0; k < 100; k++) {
15            double y=(start+end)/2;
16            double belowarea=0.0;
17            for(int i = 0; i < n; i++) {
18                double bottom = sq[i][1];
19                double height = sq[i][2];
20                double top = bottom + height;
21                if (y >= top) {
22                    belowarea += (double)height * height;
23                } else if (y > bottom) {
24                    belowarea += (y - bottom) * height;
25                }
26            }
27            if(belowarea<reqarea) {
28                start = y;
29            }else{
30                end = y;
31            }
32            farea = belowarea;
33        }
34        return start;
35    }
36}