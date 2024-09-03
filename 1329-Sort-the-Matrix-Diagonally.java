class Solution {
    public int[][] diagonalSort(int[][] mat) {
      int r,c,r1,c1,temp;
      r=mat.length;
      c=mat[0].length;
      for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            r1=i+1;c1=j+1;
            while(r1<r&&c1<c){
                  if(mat[i][j]>mat[r1][c1]){
                     temp=mat[i][j];
                     mat[i][j]=mat[r1][c1];
                     mat[r1][c1]=temp;
                  }
                  r1++;c1++;
            }
        }
      }
         return mat;
    }
}