1class Solution {
2    public int countMajoritySubarrays(int[] nums, int k) {
3        int n = nums.length;
4        int ans = 0;
5        for (int i = 0; i < n; i++) {
6            int cnt = 0;
7            for (int j = i; j < n; j++) {
8                if (nums[j] == k) {
9                    cnt++;
10                }
11                int len = j - i + 1;
12                if (cnt > len / 2) {
13                    ans++;
14                }
15            }
16        }
17        return ans;
18    }
19}