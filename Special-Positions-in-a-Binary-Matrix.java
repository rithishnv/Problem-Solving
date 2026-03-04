1class Solution {
2    public int numSpecial(int[][] mat) {
3        int res=0,n=mat.length,m=mat[0].length;
4       int[] rsum=new int[n];
5       int[] csum=new int[m];
6       for(int i=0;i<n;i++){
7        for(int j=0;j<m;j++){
8            rsum[i]+=mat[i][j];
9            csum[j]+=mat[i][j];
10        }
11       }
12       for(int i=0;i<n;i++){
13        for(int j=0;j<m;j++){
14            if(mat[i][j]==1 && rsum[i]==1 && csum[j]==1)
15            res++;
16        }
17       }
18        return res;
19    }
20}