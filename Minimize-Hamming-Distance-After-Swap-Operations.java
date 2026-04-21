1class Solution {
2    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
3        int n = source.length;
4        int ans = 0;
5        List<List<Integer>> graph = new ArrayList<>();
6
7        for (int i = 0; i < n; i++)
8            graph.add(new ArrayList<>());
9
10        for (int[] i : allowedSwaps) {
11            graph.get(i[0]).add(i[1]);
12            graph.get(i[1]).add(i[0]);
13        }
14
15        int[] visited = new int[n];
16
17        for (int i = 0; i < n; i++) {
18            if (visited[i] == 0) {
19                List<Integer> conn = new ArrayList<>();
20
21                dfs(graph, visited, conn, i);
22
23                Map<Integer, Integer> map = new HashMap<>();
24
25                for (int j : conn)
26                    map.put(source[j], map.getOrDefault(source[j], 0) + 1);
27
28                for (int j : conn)
29                    if (map.getOrDefault(target[j], 0) >= 1)
30                        map.put(target[j], map.get(target[j]) - 1);
31                    else
32                        ans += 1;
33
34            }
35        }
36        return ans;
37    }
38
39    public void dfs(List<List<Integer>> graph, int[] visited, List<Integer> conn,
40    int idx) {
41        visited[idx] = 1;
42        conn.add(idx);
43        for (int i : graph.get(idx))
44            if (visited[i] == 0)
45                dfs(graph, visited, conn, i);
46    }
47}