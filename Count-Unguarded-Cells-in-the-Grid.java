class Solution {
    int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    int res;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid=new int[m][n];
        res=n*m;
        for(int[] i:walls){
            grid[i[0]][i[1]]=1;
            res--;
        }
        for(int[] i:guards){
            grid[i[0]][i[1]]=2;
            res--;
        }
        for(int[] g:guards){
            for(int[] d:dir){
            int a=d[0]+g[0];
            int b=d[1]+g[1];
            while(!(a>=m||b>=n||a<0||b<0||grid[a][b]==1||grid[a][b]==2)){
                if(grid[a][b]==0)
                res--;
                grid[a][b]=-1;
                a+=d[0];
                b+=d[1];
            }
        }
        }
        return res;
    }
}