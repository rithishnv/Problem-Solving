class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int[] edge : adj.get(curr)) {
                min = Math.min(min, edge[1]);
                if (!visited[edge[0]]) {
                    visited[edge[0]] = true;
                    q.add(edge[0]);
                }
            }
        }
        return min;
    }
}