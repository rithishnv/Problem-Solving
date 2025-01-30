class Solution {
    List<Integer>[] graph;
    List<Integer> con=new ArrayList<>();
    int num;
    boolean[] v;
    public void dfs(int s){
        v[s]=true;
        con.add(s);
        for(int i:graph[s]){
            if(!v[i])
            dfs(i);
        }
    }
    public int bfs(int s){
        Deque<Integer> q=new ArrayDeque<>();
        int[] d=new int[num+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        int h=1;
        d[s]=1;
        q.offer(s);
        while(!q.isEmpty()){
            int p=q.poll();
            for(int i:graph[p]){
                if(d[i]==Integer.MAX_VALUE){
                    d[i]=d[p]+1;
                    h=d[i];
                    q.add(i);
                }
            }
        }
        for(int i:con){
            if(d[i]==Integer.MAX_VALUE)
            d[i]=++h;
        }
        for(int i:con){
            for(int j:graph[i]){
                if(Math.abs(d[i]-d[j])!=1)
                return -1;
            }
        }
        return h;
    }
    public int magnificentSets(int n, int[][] edges) {
        graph=new List[n+1];
        v=new boolean[n+1];
        num=n;
        int max=0;
        for(int i=0;i<=n;i++)
        graph[i]=new ArrayList<Integer>();
        for(int[] i:edges){
            graph[i[0]].add(i[1]);
            graph[i[1]].add(i[0]);
        }
        for(int i=1;i<=n;i++){
            if(!v[i]){
                dfs(i);
                int d=-1;
                for(int j:con){
                    d=Math.max(d,bfs(j));
                }
                if(d==-1)
                return -1;
                max+=d;
                con.clear();
            }
        }
        return max;
    }
}