class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res=new int[n][n];
        for(int[] q:queries){
            for(int i=q[0];i<=q[2];i++){
                    res[i][q[1]]++;
            if(q[3]+1<n){
                res[i][q[3]+1]--;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                res[i][j]+=res[i][j-1];
            }
        }
        return res;
    }
}