class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n=parent.length;
        int[] freq=new int[26];
        Arrays.fill(freq, -1);
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=1; i<n; i++){
            adj.get(parent[i]).add(i);
        }
        int[] ans=new int[n];
        dfs(adj, ans, s, parent, freq, 0);
        return ans;
    }
    
    public void dfs(List<List<Integer>> adj, int[] ans, String s, int[] parent, 
    int[] freq, int src){
        ans[src]=1;
        int c=s.charAt(src)-'a';
        int prev=freq[c];
        freq[c]=src;
        for(int v: adj.get(src)){
            dfs(adj, ans, s, parent, freq, v);
        }
        freq[c]=prev;
        if(src!=0){
            int np=(prev != -1) ? prev:parent[src];
            ans[np]+=ans[src];
        }
    }
}