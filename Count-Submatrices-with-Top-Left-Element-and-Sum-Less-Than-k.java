1class Solution {
2    public int countSubmatrices(int[][] grid, int k) {
3        int res=0;
4        if(grid[0][0]>k)
5        return 0;
6        int n=grid.length,m=grid[0].length;
7        for(int j=1;j<m;j++){
8            grid[0][j]+=grid[0][j-1];
9        }
10        for(int i=1;i<n;i++){
11            grid[i][0]+=grid[i-1][0];
12        }
13        for(int i=1;i<n;i++){
14            for(int j=1;j<m;j++){
15                grid[i][j]+=grid[i][j-1]+grid[i-1][j]-grid[i-1][j-1];
16            }
17        }
18        for(int i=0;i<n;i++){
19            for(int j=0;j<m;j++){
20                if(grid[i][j]<=k)
21                 res++;
22            }
23        }
24        return res;
25    }
26}