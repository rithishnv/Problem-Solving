1class Solution {
2    public int specialTriplets(int[] nums) {
3          int mod = 1_000_000_007, res = 0;
4        Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>();
5        for (int a : nums) {
6            right.put(a, right.getOrDefault(a, 0) + 1);
7        }
8        for (int a : nums) {
9            right.put(a, right.get(a) - 1);
10            int ci = left.getOrDefault(a * 2, 0);
11            int ck = right.getOrDefault(a * 2, 0);
12            res = (int)((res + 1L * ci * ck) % mod);
13            left.put(a, left.getOrDefault(a, 0) + 1);
14        }
15        return res;
16    }
17}