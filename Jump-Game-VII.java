1class Solution {
2    public boolean canReach(String s, int minJump, int maxJump) {
3        int n = s.length();
4        Queue<Integer> q = new LinkedList<>();
5        q.offer(0);
6        int[] vis = new int[n];
7        vis[0] = 1;
8        int cur = 0;
9        while (!q.isEmpty()) {
10            int idx = q.poll();
11            if (idx == n - 1) {
12                return true;
13            }
14            int l = Math.max(cur , idx + minJump);
15            int r = Math.min(idx + maxJump, n - 1);
16
17            for (int k = l; k <= r; k++) {
18                if (s.charAt(k) == '0' && vis[k] == 0) {
19                    vis[k] = 1;
20                    q.offer(k);
21                }
22            }
23            cur = Math.max(cur, r);
24        }
25        return false;
26    }
27}