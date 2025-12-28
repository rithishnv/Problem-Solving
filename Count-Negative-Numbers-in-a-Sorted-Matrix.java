1class Solution {
2    public int countNegatives(int[][] grid) {
3        int res=0,n=grid.length,m=grid[0].length;
4        for(int i=0;i<n;i++){
5            for(int j=0;j<m;j++){
6                if(grid[i][j]<0){
7                    res+=(m-j);
8                    break;
9                }
10            }
11        }
12        return res;
13    }
14}