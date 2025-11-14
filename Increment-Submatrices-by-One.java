class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res=new int[n][n];
        for(int[] q:queries){
            for(int i=q[0];i<=q[2];i++){
                // for(int j=q[1];j<=q[3];j++){
                    res[i][q[1]]++;
                // }
            }
            if(q[3]+1<n){
                q[3]++;
            for(int j=q[0];j<=q[2];j++){
                res[j][q[3]]--;
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