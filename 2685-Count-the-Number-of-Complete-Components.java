class Solution {
    // boolean bfs(List<List<Integer> li,int )
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] v=new boolean[n];
        List<List<Integer>> li=new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(new ArrayList<Integer>());
        }
        for(int[] i:edges){
            li.get(i[0]).add(i[1]);
            li.get(i[1]).add(i[0]);
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(!v[i]){
                boolean g=true;
                Set<Integer> set=new HashSet<>();
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                v[i]=true;
                while(!q.isEmpty()){
                    int t=q.poll();
                    set.add(t);
                    for(int j:li.get(t)){
                        if(!v[j])
                        q.add(j);
                        v[j]=true;
                       
                    }
                }
                for(int a:set){
                    if(li.get(a).size()!=set.size()-1){
                        g=false;
                        break;
                    }
                }
                if(g)
                c++;
            }
        }
        return c;
    }
}