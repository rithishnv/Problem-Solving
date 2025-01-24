class Solution {
    public boolean check(int i,int[] v,int[][] graph){
        if(v[i]!=0)
        return v[i]==2;
        v[i]=1;
        for(int j:graph[i])
        if(!check(j,v,graph))
        return false;
        v[i]=2;
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> li=new ArrayList<>();
        int[] v=new int[graph.length];
        for(int i=0;i<graph.length;i++){
                if (check(i,v,graph))
                li.add(i);
        }
        return li;
    }
}