1class Solution {
2    public int minCost(int n, int[][] edges) {
3        List<List<int[]>> graph = new ArrayList<>();
4        for (int i = 0; i < n; i++) 
5        graph.add(new ArrayList<>());
6
7        for (int[] e : edges) {
8            graph.get(e[0]).add(new int[]{e[1], e[2]});
9            graph.get(e[1]).add(new int[]{e[0], 2 * e[2]});
10        }
11
12        int[] dist = new int[n];
13        Arrays.fill(dist, Integer.MAX_VALUE);
14        dist[0] = 0;
15
16    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
17
18      pq.offer(new int[]{0, 0});
19
20      while (!pq.isEmpty()) {
21          int[] cur = pq.poll();
22          int d = cur[0], node = cur[1];
23
24          if (d > dist[node]) continue;
25
26          for (int[] edge : graph.get(node)) {
27              int next = edge[0], cost = edge[1];
28              if (dist[next] > d + cost) {
29                  dist[next] = d + cost;
30                  pq.offer(new int[]{dist[next], next});
31              }
32          }
33      }
34
35        return dist[n - 1] == Integer.MAX_VALUE ? -1 :dist[n - 1];
36    }
37}