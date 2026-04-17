1class Solution {
2    public int reverse(int x) {
3        int rev = 0;
4        while (x > 0) {
5            rev = rev * 10 + x % 10;
6            x /= 10;
7        }
8        return rev;
9    }
10
11    public int minMirrorPairDistance(int[] nums) {
12        Map<Integer, Integer> map = new HashMap<>();
13        int n = nums.length, ans = (int) 1e6;
14
15        for (int i = 0; i < n; i++) {
16            if (map.containsKey(nums[i])) {
17                ans = Math.min(ans, i - map.get(nums[i]));
18            }
19            map.put(reverse(nums[i]), i);
20        }
21
22        return ans == (int) 1e6 ? -1 : ans;
23    }
24}