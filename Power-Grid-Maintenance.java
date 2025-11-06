import java.util.*;

class Solution {
    Map<Integer, TreeSet<Integer>> mp = new HashMap<>();

    void dfs(int node, List<List<Integer>> adj, boolean[] visited, int id, int[] ids) {
        visited[node] = true;
        ids[node] = id;
        mp.putIfAbsent(id, new TreeSet<>());
        mp.get(id).add(node);

        for (int next : adj.get(node)) {
            if (!visited[next]) {
                dfs(next, adj, visited, id, ids);
            }
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        boolean[] visited = new boolean[c + 1];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= c; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] ids = new int[c + 1];

        for (int i = 1; i <= c; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, i, ids);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) { 
                int node = q[1];
                int checkId = ids[node];

                if (mp.containsKey(checkId) && mp.get(checkId).contains(node)) {
                    ans.add(node);
                } else if (mp.containsKey(checkId) && !mp.get(checkId).isEmpty()) {
                    ans.add(mp.get(checkId).first());
                } else {
                    ans.add(-1);
                }
            } else { 
                int node = q[1];
                int checkId = ids[node];

                if (mp.containsKey(checkId)) {
                    mp.get(checkId).remove(node);
                }
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
        res[i] = ans.get(i);
        }
        return res;
    }
}
