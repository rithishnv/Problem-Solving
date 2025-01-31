class Solution {
    int n;
    int c=2;
    int t=0;
    Map<Integer,Integer> map=new HashMap<>();
    int[][] d=new int[][]{{0,-1},{-1,0},{1,0},{0,1}};
    public int dfs(int[][] grid,int x,int y){
        grid[x][y]=c;
        t++;
        for(int[] k:d){
        int i=x+k[0],j=y+k[1];
        if(i<0 ||j<0 ||i>=n ||j>=n ||grid[i][j]!=1)
        continue;
        dfs(grid,i,j);
        }
        return t;
    }
    public int largestIsland(int[][] grid) {
        n=grid.length;
        map.put(0,0);
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    map.put(c,dfs(grid,i,j));
                    t=0;
                    c++;
                }
                else if(grid[i][j]==0)
                q.add(new int[]{i,j});
            }
        }
        int max=0;
        if(q.isEmpty())
        return n*n;
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int cnt=0;
            Set<Integer> set=new HashSet<>();
            for(int[] i:d){
                int x=arr[0]+i[0],y=arr[1]+i[1];
                if(x>=0 && y>=0 && x<n && y<n){
                if(set.add(grid[x][y]))
                cnt+=map.get(grid[x][y]);
                }
            }
            max=Math.max(cnt+1,max);
        }
            return max;
    }
}