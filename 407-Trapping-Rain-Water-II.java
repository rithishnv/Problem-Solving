class Solution {
    public int trapRainWater(int[][] heightMap) {
        int r=heightMap.length,c=heightMap[0].length,s=0;
        boolean[][] v=new boolean[r][c];
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0 ||j==0 ||j==c-1||i==r-1){
                    q.offer(new int[]{heightMap[i][j],i,j});
                    v[i][j]=true;
                }
            }
        }
        int[][] d=new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while(!q.isEmpty()){
            int[] a=q.poll();
            int i=a[1],j=a[2];
            for(int k=0;k<4;k++){
                int x=i+d[k][0],y=j+d[k][1];
                if(x>=0 && y>=0 && x<r &&y<c &&!v[x][y]){
                s+=Math.max(0,a[0]-heightMap[x][y]);
                v[x][y]=true;
                q.offer(new int[]{Math.max(a[0],heightMap[x][y]),x,y});
                }
            }
        }
        return s;
    }
}