1class Solution {
2    public int countCoveredBuildings(int n, int[][] buildings) {
3        Map<Integer, int[]> yRangeGivenX = new HashMap<>();
4        Map<Integer, int[]> xRangeGivenY = new HashMap<>();
5        
6        for (int[] b : buildings) {
7            int x = b[0], y = b[1];
8            yRangeGivenX.putIfAbsent(x, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
9            yRangeGivenX.get(x)[0] = Math.min(yRangeGivenX.get(x)[0], y);
10            yRangeGivenX.get(x)[1] = Math.max(yRangeGivenX.get(x)[1], y);
11
12            xRangeGivenY.putIfAbsent(y, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
13            xRangeGivenY.get(y)[0] = Math.min(xRangeGivenY.get(y)[0], x);
14            xRangeGivenY.get(y)[1] = Math.max(xRangeGivenY.get(y)[1], x);
15        }
16        
17        int count = 0;
18        for (int[] b : buildings) {
19            int x = b[0], y = b[1];
20            if (xRangeGivenY.get(y)[0] < x && x < xRangeGivenY.get(y)[1] &&
21                yRangeGivenX.get(x)[0] < y && y < yRangeGivenX.get(x)[1]) {
22                count++;
23            }
24        }
25        
26        return count;
27    }
28}