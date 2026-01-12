1class Solution {
2    public int minTimeToVisitAllPoints(int[][] points) {
3        int res=0;
4        for(int i=0;i<points.length-1;i++){
5            res+=Math.max(Math.abs(points[i][0]-points[i+1][0]),
6            Math.abs(points[i][1]-points[i+1][1]));
7        }
8        return res;
9    }
10}