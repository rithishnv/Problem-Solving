1class Solution {
2    public boolean canReach(String s, int minJump, int maxJump) {
3        int n = s.length();
4        boolean[] vis = new boolean[n];
5        vis[0]=true;
6        int cur = 0;
7        for(int idx=0;idx<n;idx++){
8            if(!vis[idx]){
9                continue;
10            }
11            int l = Math.max(cur+1 , idx + minJump);
12            int r = Math.min(idx + maxJump, n - 1);
13
14            for (int k = l; k <= r; k++) {
15                if (s.charAt(k) == '0' && !vis[k]) {
16                    vis[k] = true;
17                }
18            }
19            cur = Math.max(cur, r);
20        }
21        return vis[n-1];
22    }
23}