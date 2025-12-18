1class Solution {
2    public long maxProfit(int[] prices, int[] strategy, int k) {
3        int n = prices.length;
4        long[] prefix_origin = new long[n + 1];
5        prefix_origin[0] = 0;
6        for (int i = 1; i <= n; i++) {
7            prefix_origin[i] = prefix_origin[i - 1] + prices[i - 1] * strategy[i - 1];
8        }
9        long[] prefix_modify = new long[n + 1];
10        prefix_modify[0] = 0;
11        for (int i = 1; i <= n; i++) {
12            prefix_modify[i] = prefix_modify[i - 1] + prices[i - 1];
13        }
14        int l = 1, r = k;
15        long res = prefix_origin[n];
16        while (r <= n) {
17            int mid = (l+r)/2;
18            res = Math.max(res,
19                    prefix_origin[n] - prefix_origin[r] + prefix_origin[l - 1] + (prefix_modify[r] - prefix_modify[mid]));
20            r++;
21            l++;
22        }
23        return res;
24    }
25}