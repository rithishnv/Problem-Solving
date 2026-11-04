class Solution {
    class Heap {
        int size = 0;
        long sum = 0;
        TreeMap<Integer, Integer> data = new TreeMap<>();
        public void add(int num) {
            sum += num;
            size += 1;
            data.put(num, data.getOrDefault(num, 0) + 1);
        }
        public void remove(int num) {
            sum -= num;
            size -= 1;
            data.put(num, data.get(num) - 1);
            if (data.get(num) == 0) { data.remove(num); }
        }
        public int getFirst() { return data.firstKey(); }
        public int getLast() { return data.lastKey(); }
    }
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long [] costs = new long[n];
        Arrays.fill(costs, Long.MAX_VALUE);
        Heap leftPart = new Heap();
        Heap rightPart = new Heap();
        for (int i = 0; i < n; i++) {
            int added = nums[i];
            if (leftPart.size == 0 && rightPart.size == 0) {
                leftPart.add(added);
                continue;
            }
            int transfer;
            if (leftPart.size <= rightPart.size) {
                transfer = rightPart.getFirst();
                rightPart.remove(transfer);
            } else {
                transfer = leftPart.getLast();
                leftPart.remove(transfer);
            }
            leftPart.add(Math.min(added, transfer));
            rightPart.add(Math.max(added, transfer));

            if (leftPart.size + rightPart.size == x) {
                long median = leftPart.getLast();
                costs[i] = median * leftPart.size - leftPart.sum + rightPart.sum - median * rightPart.size;
                int outed = nums[i-x+1];
                if (outed <= median) {
                    leftPart.remove(outed);
                } else {
                    rightPart.remove(outed);
                }
            }
        }

        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        for (int i = x-1; i < n; i++) {
            dp[i] = Math.min(dp[i-1], costs[i]);
        }
        for (int i = 1; i < k; i++) {
            long[] newDP = new long[n];
            Arrays.fill(newDP, Long.MAX_VALUE);
            for (int j = (i+1) * x - 1; j < n; j++) {
                newDP[j] = Math.min(newDP[j-1], costs[j] + dp[j-x]);
            }
            dp = newDP;
        }
        return dp[n-1];
    }
}