class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[] arr=new int[n*m];
        int i=0,j=0;
       for(int k=0;k<n*m;k++){
        arr[k]=mat[i][j];
        if((i+j)%2==0){
            if(j==m-1) i++;
            else if(i==0) j++;
            else{
                i--;
                j++;
            }
        }
        else{
            if(i==n-1) j++;
            else if(j==0) i++;
            else{
                i++;
                j--;
            }
        }
       }
        return arr;
    }
}