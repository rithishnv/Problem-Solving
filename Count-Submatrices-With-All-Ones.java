class Solution {
    public int numSubmat(int[][] matrix) {
        int res=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[] arr=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[j]=(matrix[i][j]==1)?arr[j]+1:0;
            }
            for(int j=0;j<m;j++){
                int t=arr[j];
                for(int k=j;k>-1 && t>0;k--){
                    t=Math.min(t,arr[k]);
                    res+=t;
                }
            }
        }
        return res;
    }
}