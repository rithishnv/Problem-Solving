1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        int  n=grid.length,m=grid[0].length;
4        long[] c=new long[m];
5        long[] r=new long[n];
6        for(int i=0;i<n;i++){
7            for(int j=0;j<m;j++){
8                c[j]+=grid[i][j];
9                r[i]+=grid[i][j];
10            }
11        }
12        long csum=0,rsum=0;
13        for(long i:c){
14            csum+=i;
15        }
16        for(long i:r){
17            rsum+=i;
18        }
19        long t=0;
20        for(int i=m-1;i>-1;i--){
21            t+=c[i];
22            csum-=c[i];
23            if(csum==t)
24            return true;
25        }
26        t=0;
27        for(int i=n-1;i>-1;i--){
28            t+=r[i];
29            rsum-=r[i];
30            if(rsum==t)
31            return true;
32        }
33        return false;
34    }
35}