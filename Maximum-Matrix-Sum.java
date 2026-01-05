1class Solution {
2    public long maxMatrixSum(int[][] matrix) {
3        long res=0;
4        int c=0,min=Integer.MAX_VALUE;
5        for(int i=0;i<matrix.length;i++){
6            for(int j=0;j<matrix[0].length;j++){
7                if(matrix[i][j]<0){
8                    matrix[i][j]*=-1;
9                    c++;
10                }
11                    min=Math.min(matrix[i][j],min);
12                    res+=matrix[i][j];
13            }
14        }
15        if(c%2==0)
16        return res;
17        return res-2*min;
18    }
19}