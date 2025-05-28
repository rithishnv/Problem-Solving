class Solution {
    public List<List<Integer>> build(int[][] edge){
        List<List<Integer>> li=new ArrayList<>();
        int n=edge.length;
        for(int i=0;i<=n;i++)
        li.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            li.get(edge[i][0]).add(edge[i][1]);
            li.get(edge[i][1]).add(edge[i][0]);
        }
        return li;
    }
    public int dfs(List<List<Integer>> adj,int u,int p,int k){
        if(k<0)
        return 0;
        int cnt=1;
        for(int v:adj.get(u)){
            if(v!=p)
            cnt+=dfs(adj,v,u,k-1);
        }
        return cnt;
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> adj1=build(edges1);
        List<List<Integer>> adj2=build(edges2);
        int max=0;
        int n=edges1.length+1;
        for(int i=0;i<edges2.length+1;i++){
            max=Math.max(max,dfs(adj2,i,-1,k-1));
        }
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=dfs(adj1,i,-1,k)+max;
        }
        return arr;
    }
}