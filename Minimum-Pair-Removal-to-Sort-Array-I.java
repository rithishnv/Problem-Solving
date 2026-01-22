1class Solution {
2    private boolean isSorted(int[] nums, int n) {
3        for(int i = 1; i < n; i++) {
4            if(nums[i] < nums[i - 1]) return false;
5        }
6        return true;
7    }
8    public int minimumPairRemoval(int[] nums) {
9        int ans = 0, n = nums.length;
10        while(!isSorted(nums, n)) {
11            ans += 1;
12            int min_sum = Integer.MAX_VALUE, pos = -1;
13            for(int i = 1; i < n; i++) {
14                int sum = nums[i - 1] + nums[i];
15                if(sum < min_sum) {
16                    min_sum = sum;
17                    pos = i;
18                }
19            }
20            nums[pos - 1] = min_sum;
21            for(int i = pos; i < n - 1; i++) nums[i] = nums[i + 1];
22            n--;
23        }
24        return ans;
25    }
26}