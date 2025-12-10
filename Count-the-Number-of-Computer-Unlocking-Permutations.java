1class Solution {
2    public int countPermutations(int[] nums) {
3        int MOD = (int)1e9 + 7;
4        int n = nums.length;
5        int min = Integer.MAX_VALUE;
6        for (int num : nums) {
7            min = Math.min(min, num);
8        }
9
10        if (nums[0] != min) return 0;
11
12        int cnt = 0;
13        for (int num : nums) {
14            if (num == min) cnt++;
15            if (cnt > 1) return 0;
16        }
17
18        long ans = 1;
19        for (int i = 1; i < n; i++) {
20            ans = (ans * i) % MOD;
21        }
22
23        return (int)ans;
24    }
25}