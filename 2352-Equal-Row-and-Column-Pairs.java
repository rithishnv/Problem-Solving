class Solution {
    public int equalPairs(int[][] grid) {
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][0]==grid[0][j]){
                    int f=0;
                    for(int k=0;k<grid.length;k++){
                        if(grid[i][k]!=grid[k][j]){
                            f=1;
                            break;
                        }
                    }
                    if(f==0)
                    c++;
                }
            }
        }
        return c;
    }
}