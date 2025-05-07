class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length,m=moveTime[0].length;
        int[][] arr=new int[n][m];
        int max=Integer.MAX_VALUE;
        for(int[] i:arr){
            Arrays.fill(i,max);
        }
        int[][] d={{0,1},{0,-1},{1,0},{-1,0}}; 
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        pq.offer(new int[]{0,0,0});
        moveTime[0][0]=-1;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int t=cur[0],i=cur[1],j=cur[2];
            if(t>=arr[i][j])
            continue;
            if(i==n-1 && j==m-1)
            return t;
            arr[i][j]=t;
            for(int[] a:d){
                int x=i+a[0],y=j+a[1];
                if(x>=0 && y>=0 && x<n && y<m && arr[x][y]==max)
                pq.add(new int[]{Math.max(moveTime[x][y],t)+1,x,y});
            }
        }
        return -1;
    }
}