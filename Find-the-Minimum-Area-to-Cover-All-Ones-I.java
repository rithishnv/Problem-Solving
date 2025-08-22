class Solution {
    public int minimumArea(int[][] grid) {
        int lr=grid.length,lc=grid[0].length,mr=-1,mc=-1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    lr=Math.min(i,lr);
                    lc=Math.min(j,lc);
                    mr=Math.max(i,mr);
                    mc=Math.max(j,mc);
                }
            }
        }
        int h=mr-lr+1;
        int w=mc-lc+1;
        return h*w;
    }
}