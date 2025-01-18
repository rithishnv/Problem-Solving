class Solution {
    public int minCost(int[][] grid) {
        Deque<int[]> q=new ArrayDeque<>();
        int r=grid.length,c=grid[0].length;
        boolean[][] v=new boolean[grid.length][grid[0].length];
        q.offer(new int[]{0,0,0});
        int[][] b=new int[][]{{0,0},{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] a=q.poll();
            int i=a[0],j=a[1],t=a[2];
            if(i==r-1 && j==c-1)
            return t;
            if (v[i][j])
            continue;
            v[i][j]=true;
            for(int k=1;k<=4;k++){
                int r1=i+b[k][0],c1=j+b[k][1];
                if(r1<0 || c1<0 || c1==c || r1==r)
                continue;
                if(grid[i][j]==k)
                q.offerFirst(new int[]{r1,c1,t});
                else
                q.offer(new int[]{r1,c1,t+1});
            }
        }
        return -1;
    }
}