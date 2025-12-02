1class Solution {
2    public int countTrapezoids(int[][] points) {
3        long MOD = 1000000007;
4        Map<Integer, Long> freq = new HashMap<>();
5        for (int[] p : points) {
6            freq.put(p[1], freq.getOrDefault(p[1], 0L) + 1);
7        }
8        List<Long> pairs = new ArrayList<>();
9        for (long v : freq.values()) {
10            if (v >= 2) {
11                long c = v * (v - 1) / 2;
12                pairs.add(c % MOD);
13            }
14        }
15        long sum = 0, ans = 0;
16        for (long x : pairs) {
17            ans = (ans + x * sum) % MOD;
18            sum = (sum + x) % MOD;
19        }
20        return (int) ans;
21    }
22}