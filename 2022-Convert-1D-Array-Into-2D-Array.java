class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length!=m*n)
        return new int[0][0];
        int[][] r=new int[m][n];
        int k=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                r[i][j]=original[k++];
            }
        }
        return r;
    }
}