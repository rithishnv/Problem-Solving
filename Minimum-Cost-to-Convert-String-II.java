1class Solution {
2    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
3        HashMap<String, Integer> index = new HashMap<>();
4        for (String o : original) {
5            if (!index.containsKey(o)) {
6                index.put(o, index.size());
7            }
8        }
9        for (String c : changed) {
10            if (!index.containsKey(c)) {
11                index.put(c, index.size());
12            }
13        }
14        long[][] dis = new long[index.size()][index.size()];
15        for (int i = 0; i < dis.length; i++) {
16            Arrays.fill(dis[i], Long.MAX_VALUE);
17            dis[i][i] = 0;
18        }
19        for (int i = 0; i < cost.length; i++) {
20            dis[index.get(original[i])][index.get(changed[i])] = Math.min(dis[index.get(original[i])][index.get(changed[i])], (long)cost[i]);
21        }
22        for (int k = 0; k < dis.length; k++) {
23            for (int i = 0; i < dis.length; i++)
24                if (dis[i][k] < Long.MAX_VALUE) {
25                    for (int j = 0; j < dis.length; j++) {
26                        if (dis[k][j] < Long.MAX_VALUE) {
27                            dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
28                        }
29                    }
30                }
31        }
32        HashSet<Integer> set = new HashSet<>();
33        for (String o : original) {
34            set.add(o.length());
35        }
36        long[] dp = new long[target.length() + 1];
37        Arrays.fill(dp, Long.MAX_VALUE);
38        dp[0] = 0L;
39        for (int i = 0; i < target.length(); i++) {
40            if (dp[i] == Long.MAX_VALUE) {
41                continue;
42            }
43            if (target.charAt(i) == source.charAt(i)) {
44                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
45            }
46            for (int t : set) {
47                if (i + t >= dp.length) {
48                    continue;
49                }
50                int c1 = index.getOrDefault(source.substring(i, i + t), -1);
51                int c2 = index.getOrDefault(target.substring(i, i + t), -1);
52                if (c1 >= 0 && c2 >= 0 && dis[c1][c2] < Long.MAX_VALUE) {
53                    dp[i + t] = Math.min(dp[i + t], dp[i] + dis[c1][c2]);
54                }
55            }
56        }
57        return dp[dp.length - 1] == Long.MAX_VALUE ? -1L : dp[dp.length - 1];
58    }
59}