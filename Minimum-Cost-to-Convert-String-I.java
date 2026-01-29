1class Solution {
2    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
3        int[][] dis = new int[26][26];
4        for (int i = 0; i < 26; i++) {
5            Arrays.fill(dis[i], Integer.MAX_VALUE);
6            dis[i][i] = 0;
7        }
8        for (int i = 0; i < cost.length; i++) {
9            dis[original[i] - 'a'][changed[i] - 'a'] = Math.min(dis[original[i] - 'a'][changed[i] - 'a'], cost[i]);
10        }
11        for (int k = 0; k < 26; k++) {
12            for (int i = 0; i < 26; i++)
13                if (dis[i][k] < Integer.MAX_VALUE) {
14                    for (int j = 0; j < 26; j++) {
15                        if (dis[k][j] < Integer.MAX_VALUE) {
16                            dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
17                        }
18                    }
19                }
20        }
21        long ans = 0L;
22        for (int i = 0; i < source.length(); i++) {
23            int c1 = source.charAt(i) - 'a';
24            int c2 = target.charAt(i) - 'a';
25            if (dis[c1][c2] == Integer.MAX_VALUE) {
26                return -1L;
27            } else {
28                ans += (long)dis[c1][c2];
29            }
30        }
31        return ans;
32    }
33}