class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        int[] indeg=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] i:edges){
            adj.get(i[0]).add(i[1]);
            indeg[i[1]]++;
        }
        Queue<Integer> zerodeg=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0)
            zerodeg.add(i);
        }
        int[][] cnt=new int[n][26];
        for(int i=0;i<n;i++){
            cnt[i][colors.charAt(i)-'a']++;
        }
        int max=0;
        int vis=0;
        while(!zerodeg.isEmpty()){
            int u=zerodeg.poll();
            vis++;
            for(int v:adj.get(u)){
                for(int j=0;j<26;j++){
                    cnt[v][j]=Math.max(cnt[v][j],cnt[u][j]+(colors.charAt(v)-'a'==j?1:0));
                }
                indeg[v]--;
                if(indeg[v]==0)
                zerodeg.add(v);
            }
            max=Math.max(max,Arrays.stream(cnt[u]).max().getAsInt());
        }
        return vis==n?max:-1;
    }
}