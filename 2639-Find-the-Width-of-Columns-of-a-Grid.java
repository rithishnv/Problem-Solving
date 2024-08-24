class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] a=new int[grid[0].length];
        for(int j=0;j<grid[0].length;j++){
            int max=1;
            for(int i=0;i<grid.length;i++){
                int c=0;
                if(grid[i][j]<0){
                    grid[i][j]*=-1;
                    c++;
                }
                while(grid[i][j]!=0){
                    c++;
                    grid[i][j]/=10;
                }
                max=Math.max(max,c);
            }
            a[j]=max;
        }
        return a;
    }
}