1class Solution {
2    public int[] maxValue(int[] nums) {
3        int n = nums.length;
4        int[] pre = new int[n];
5        int suf = nums[n-1];
6        pre[0]=nums[0];
7        for (int i = 1; i < n; i++)
8            pre[i] = Math.max(pre[i-1], nums[i]);
9        for (int i = n - 2; i >= 0; i--) {
10            if (pre[i] > suf)
11            pre[i] = pre[i + 1];
12            suf = Math.min(nums[i], suf);
13        }
14        return pre;
15    }
16}