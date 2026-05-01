1class Solution {
2    public int maxRotateFunction(int[] nums) {
3        int f = 0;
4        int n = nums.length;
5        int numSum = 0;
6        for (int i = 0; i < n; i++) {
7            f += i * nums[i];
8            numSum+=nums[i];
9        }
10        int res = f;
11        for (int i = n - 1; i > 0; i--) {
12            f += numSum - n * nums[i];
13            res = Math.max(res, f);
14        }
15        return res;
16    }
17}