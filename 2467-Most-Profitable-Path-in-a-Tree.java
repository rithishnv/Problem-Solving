class Solution {
    int[] time;
    List<List<Integer>> li=new ArrayList<>();
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n=amount.length;
        for(int i=0;i<n;i++)
        li.add(new ArrayList<Integer>());
        for(int[] i:edges){
            li.get(i[0]).add(i[1]);
            li.get(i[1]).add(i[0]);
        }
        time=new int[n];
        Arrays.fill(time,-1);
        dfs(bob,0,new boolean[n]);
        return afs(0,-1,0,amount);
    }
    boolean dfs(int node,int t,boolean[] v){
        if(node==0){
        time[node]=t;
        return true;
        }
        v[node]=true;
        for(int i:li.get(node)){
            if(!v[i])
            if(dfs(i,t+1,v)){
            time[node]=t;
            return true;
            }
        }
        v[node]=false;
        return false;
    }
    int afs(int node,int p,int t,int[] amount){
        int sum=Integer.MIN_VALUE;
        boolean leaf=true;
        for(int i:li.get(node)){
            if(i!=p){
                leaf=false;
                sum=Math.max(sum,afs(i,node,t+1,amount));
            }
        }
        if(time[node]==-1 || time[node]>t)
        return leaf ? amount[node] : sum+amount[node];
        else if(time[node]==t)
        return leaf?amount[node]/2:sum+amount[node]/2;
        return leaf?0:sum;
    }
}