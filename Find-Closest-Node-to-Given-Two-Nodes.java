class Solution {
    public void dfs(int[] edges,int d,int[] m,int node){
        while(node!=-1 && m[node]==-1){
            m[node]=d++;
            node=edges[node];
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] m1=new int[edges.length];
        int[] m2=new int[edges.length];
        Arrays.fill(m1,-1);
        Arrays.fill(m2,-1);
        dfs(edges,0,m1,node1);
        dfs(edges,0,m2,node2);
        int maxd=Integer.MAX_VALUE,ind=-1;
        for(int i=0;i<edges.length;i++){
            if(Math.min(m1[i],m2[i])>=0 && Math.max(m1[i],m2[i])<maxd){
                maxd=Math.max(m1[i],m2[i]);
                ind=i;
            }
        }
        return ind;
    }
}