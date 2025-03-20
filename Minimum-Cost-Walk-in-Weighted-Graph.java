class Solution {
    int find(int[] parent,int s){
        if(parent[s]!=s){
            parent[s]=find(parent,parent[s]);
        }
        return parent[s];
    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] parent=new int[n];
        int[] cost=new int[n];
        Arrays.fill(cost,-1);
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int[] e:edges){
            int s=find(parent,e[0]);
            int t=find(parent,e[1]);
            cost[t]&=e[2];
            if(s!=t){
                cost[t]&=cost[s];
                parent[s]=t;
            }
        }
        int[] res=new int[query.length];
        int j=0;
        for(int[] i:query){
            if(i[0]==i[1])
            res[j++]=0;
            else if(find(parent,i[0])!=find(parent,i[1]))
            res[j++]=-1;
            else
            res[j++]=cost[find(parent,i[0])];
        }
        return res;
    }
}