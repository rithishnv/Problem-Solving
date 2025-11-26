1class Solution {
2    public int numberOfPaths(int[][] grid, int k) {
3        int n=grid.length,m=grid[0].length;
4        int[][][] arr=new int[n][m][k];
5        int t=0;
6        for(int i=0;i<n;i++){
7            t+=grid[i][0];
8            arr[i][0][t%k]++;
9        }
10        t=grid[0][0];
11        for(int j=1;j<m;j++){
12            t+=grid[0][j];
13            arr[0][j][t%k]++;
14        }
15        for(int i=1;i<n;i++){
16            for(int j=1;j<m;j++){
17                for(int e=0;e<k;e++){
18                    arr[i][j][(grid[i][j]+e)%k]=(arr[i][j-1][e]+arr[i-1][j][e])%1000000007;
19                }
20            }
21        }
22        return arr[n-1][m-1][0];
23    }
24}