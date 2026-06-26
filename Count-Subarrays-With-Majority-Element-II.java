1class Solution {
2    public long countMajoritySubarrays(int[] nums, int target) {
3        int n = nums.length;
4        int balance = n + 1;
5        int[] freq = new int[2 * n + 2];
6        int[] pref = new int[2 * n + 2];
7        freq[balance] = 1;
8        pref[balance] = 1;
9        long answer = 0;
10        for (int num : nums) {
11            if (num == target) {
12                balance++;
13            } else {
14                balance--;
15            }
16            freq[balance]++;
17            pref[balance] = pref[balance - 1] + freq[balance];
18            answer += pref[balance - 1];
19        }
20
21        return answer;
22    }
23}