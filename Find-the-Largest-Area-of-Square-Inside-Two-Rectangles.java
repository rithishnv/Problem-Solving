1class Solution {
2    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
3    int n = bottomLeft.length;
4        long maxSide = 0;
5        for (int i = 0; i < n; i++) {
6            for (int j = i + 1; j < n; j++) {
7                int w =
8                    Math.min(topRight[i][0], topRight[j][0]) -
9                    Math.max(bottomLeft[i][0], bottomLeft[j][0]);
10                int h =
11                    Math.min(topRight[i][1], topRight[j][1]) -
12                    Math.max(bottomLeft[i][1], bottomLeft[j][1]);
13                int side = Math.min(w, h);
14
15                maxSide = Math.max(maxSide, side);
16            }
17        }
18
19        return maxSide * maxSide;
20    }
21}