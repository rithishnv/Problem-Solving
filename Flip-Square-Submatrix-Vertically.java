1class Solution {
2    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
3       int i=x;
4       int j=x+k-1;
5       while(i<j){
6        for(int a=y;a<y+k;a++){
7            int t=grid[i][a];
8            grid[i][a]=grid[j][a];
9            grid[j][a]=t;
10        }
11        i++;
12        j--;
13       }
14        return grid;
15    }
16}