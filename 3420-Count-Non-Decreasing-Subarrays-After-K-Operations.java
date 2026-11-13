class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        int r = n-1;
        long ans = 0;
        long change = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int l = n-1; l >= 0; l--){
            int curMin = nums[l];
            int curMinCount = 1;
            while (!deque.isEmpty() && deque.peekFirst()[0] <= curMin){
                int[] pair = deque.pollFirst();
                curMinCount += pair[1];
                change += (long)(curMin-pair[0]) * pair[1];
            }
            deque.offerFirst(new int[]{curMin, curMinCount});
            while (change > k){
                int[] last = deque.peekLast();
                last[1]--;
                change -= last[0] - nums[r];
                r--;
                if (last[1] == 0) deque.pollLast();
            }
            ans += r-l+1;
        }
        return ans;
    }
}