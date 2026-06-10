1class Solution {
2    public long maxTotalValue(int[] nums, int k) {
3        int n = nums.length;
4        int logn = 32 - Integer.numberOfLeadingZeros(n);
5        int[][] stMax = new int[n][logn];
6        int[][] stMin = new int[n][logn];
7        for (int i = 0; i < n; i++) {
8            stMax[i][0] = stMin[i][0] = nums[i];
9        }
10        for (int j = 1; j < logn; j++) {
11            for (int i = 0; i + (1 << j) <= n; i++) {
12                stMax[i][j] = Math.max(
13                    stMax[i][j - 1],
14                    stMax[i + (1 << (j - 1))][j - 1]
15                );
16                stMin[i][j] = Math.min(
17                    stMin[i][j - 1],
18                    stMin[i + (1 << (j - 1))][j - 1]
19                );
20            }
21        }
22        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
23        for (int l = 0; l < n; l++) {
24            int j = 31 - Integer.numberOfLeadingZeros(n - 1 - l + 1);
25            int mx = Math.max(stMax[l][j], stMax[n - 1 - (1 << j) + 1][j]);
26            int mn = Math.min(stMin[l][j], stMin[n - 1 - (1 << j) + 1][j]);
27            pq.offer(new int[] { mx - mn, l, n - 1 });
28        }
29        long ans = 0;
30        while (k-- > 0) {
31            int[] top = pq.poll();
32            ans += top[0];
33            int l = top[1];
34            int r = top[2];
35            if (r > l) {
36                int j = 31 - Integer.numberOfLeadingZeros(r - 1 - l + 1);
37                int mx = Math.max(stMax[l][j], stMax[r - 1 - (1 << j) + 1][j]);
38                int mn = Math.min(stMin[l][j], stMin[r - 1 - (1 << j) + 1][j]);
39                pq.offer(new int[] { mx - mn, l, r - 1 });
40            }
41        }
42        return ans;
43    }
44}