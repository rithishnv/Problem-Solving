1class Solution {
2    public long maxSumTrionic(int[] nums) {
3    int n = nums.length;
4    long res = Long.MIN_VALUE;
5    long psum = nums[0];
6    int l = 0, p = 0, q = 0;
7    
8    for (int r = 1; r < n; ++r) {
9        psum += nums[r];
10
11        if (nums[r - 1] == nums[r]) {
12            l = r;
13            psum = nums[r];
14        } 
15        else if (nums[r - 1] > nums[r]) {
16            if (r > 1 && nums[r - 2] < nums[r - 1]) {
17                p = r - 1;
18                while (l < q) {
19                    psum -= nums[l++];
20                }
21                while (l + 1 < p && nums[l] < 0) {
22                    psum -= nums[l++];
23                }
24            }
25        } 
26        else {
27            if (r > 1 && nums[r - 2] > nums[r - 1]) { 
28                q = r - 1;
29            }
30            if (l < p && p < q) {
31                res = Math.max(res, psum);
32            }
33        }
34    }
35
36    return res;
37}
38
39}