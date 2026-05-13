1class Solution {
2    public int minMoves(int[] nums, int limit) {
3        int n = nums.length;
4        int[] diff = new int[2 * limit + 2];
5        int i = 0;
6        int j = n - 1;
7        while (i < j) {
8            int a = nums[i];
9            int b = nums[j];
10            int low = Math.min(a, b) + 1;
11            int high = Math.max(a, b) + limit;
12            int sum = a + b;
13            diff[2] += 2;
14            diff[low] -= 1;
15            diff[sum] -= 1;
16            diff[sum + 1] += 1;
17            diff[high + 1] += 1;
18            i++;
19            j--;
20        }
21        int ans = Integer.MAX_VALUE;
22        int curr = 0;
23        for (int s = 2; s <= 2 * limit; s++) {
24            curr += diff[s];
25            ans = Math.min(ans, curr);
26        }
27        return ans;
28    }
29}