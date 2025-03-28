class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[][] bfs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int n=queries.length;
        int[][] map=new int[n][2];
        int r=grid.length;
        int c=grid[0].length;
        for(int i=0;i<queries.length;i++){
            map[i][0]=queries[i];
            map[i][1]=i;
        }
        Arrays.sort(map,(a,b)->a[0]-b[0]);
        int[] res=new int[queries.length];
        boolean[][] v=new boolean[r][c];
        pq.offer(new int[]{grid[0][0],0,0});
        v[0][0]=true;
        int cnt=0;
        for(int[] t:map){
            while(!pq.isEmpty() &&pq.peek()[0]<t[0]){
                cnt++;
                int[] a=pq.poll();
                for(int[] d:bfs){
                    int x=a[1]+d[0],y=a[2]+d[1];
                    if(x>=0 && y>=0 && x<r && y<c && !v[x][y]){
                    pq.add(new int[]{grid[x][y],x,y});
                    v[x][y]=true;
                    }
                }
            }
            res[t[1]]=cnt;
        }
        return res;
    }
}