1class Solution {
2    private static final int MOD = 1_000_000_007;
3
4    private int LOG;
5    private int[][] up;
6    private int[] depth;
7    private List<Integer>[] adj;
8
9    private long modPow(long a, long b) {
10        long ans = 1;
11
12        while (b > 0) {
13            if ((b & 1) == 1) {
14                ans = (ans * a) % MOD;
15            }
16
17            a = (a * a) % MOD;
18            b >>= 1;
19        }
20
21        return ans;
22    }
23
24    private void dfs(int node, int parent) {
25        up[node][0] = parent;
26
27        for (int j = 1; j < LOG; j++) {
28            up[node][j] = up[up[node][j - 1]][j - 1];
29        }
30
31        for (int neighbour : adj[node]) {
32            if (neighbour == parent) continue;
33
34            depth[neighbour] = depth[node] + 1;
35            dfs(neighbour, node);
36        }
37    }
38
39    private int lca(int u, int v) {
40        if (depth[u] < depth[v]) {
41            int temp = u;
42            u = v;
43            v = temp;
44        }
45
46        int diff = depth[u] - depth[v];
47
48        for (int j = LOG - 1; j >= 0; j--) {
49            if ((diff & (1 << j)) != 0) {
50                u = up[u][j];
51            }
52        }
53
54        if (u == v) return u;
55
56        for (int j = LOG - 1; j >= 0; j--) {
57            if (up[u][j] != up[v][j]) {
58                u = up[u][j];
59                v = up[v][j];
60            }
61        }
62
63        return up[u][0];
64    }
65
66    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
67        int n = edges.length + 1;
68
69        LOG = 1;
70        while ((1 << LOG) <= n) LOG++;
71
72        adj = new ArrayList[n + 1];
73        for (int i = 0; i <= n; i++) {
74            adj[i] = new ArrayList<>();
75        }
76
77        for (int[] edge : edges) {
78            int u = edge[0];
79            int v = edge[1];
80
81            adj[u].add(v);
82            adj[v].add(u);
83        }
84
85        depth = new int[n + 1];
86        up = new int[n + 1][LOG];
87
88        dfs(1, 0);
89
90        int[] ans = new int[queries.length];
91
92        for (int i = 0; i < queries.length; i++) {
93            int u = queries[i][0];
94            int v = queries[i][1];
95
96            int L = lca(u, v);
97
98            long dist = depth[u] + depth[v] - 2L * depth[L];
99
100            if (dist == 0) {
101                ans[i] = 0;
102            } else {
103                ans[i] = (int) modPow(2, dist - 1);
104            }
105        }
106
107        return ans;
108    }
109}