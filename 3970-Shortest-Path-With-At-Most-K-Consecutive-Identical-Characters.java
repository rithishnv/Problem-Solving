class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }
        int[][] dist = new int[n][k + 1];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int u = cur[1];
            int cnt = cur[2];
            if (cost != dist[u][cnt]){
                continue;
            }
            if (u == n - 1){
                return cost;
            }
            for (int[] e : graph[u]) {
                int v = e[0];
                int w = e[1];
                int nextCount = labels.charAt(u) == labels.charAt(v)
                    ? cnt + 1 : 1;
                if (nextCount > k){
                    continue;
                }
                int newCost = cost + w;
                if (newCost < dist[v][nextCount]) {
                    dist[v][nextCount] = newCost;
                    pq.offer(new int[]{newCost, v, nextCount});
                }
            }
        }
        return -1;
    }
}