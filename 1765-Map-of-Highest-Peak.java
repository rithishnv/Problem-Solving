class Solution {
    public int[][] highestPeak(int[][] w) {
        int r=w.length,c=w[0].length;
        int[][] arr=new int[r][c];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(w[i][j]==1){
                    arr[i][j]=0;
                    q.add(new int[]{i,j});
                }
               else
               arr[i][j]=-1;
            }
        }
    int[][] d=new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
      while(!q.isEmpty()){
        int[] a=q.poll();
        for(int i=0;i<4;i++){
            int x=a[0]+d[i][0],y=a[1]+d[i][1];
            if(x>=0 && y>=0 && x<r && y<c && arr[x][y]==-1){
                arr[x][y]=arr[a[0]][a[1]]+1;
                q.add(new int[]{x,y});
            }
            
        }
      }
      return arr;
    }
}