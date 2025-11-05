class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        TreeSet<long[]> left = new TreeSet<>(
                (o, p) -> o[0] == p[0] ? Long.compare(o[1], p[1]) : Long.compare(o[0], p[0])),
                right = new TreeSet<>((o, p) -> o[0] == p[0] ? Long.compare(p[1], o[1]) : Long.compare(p[0], o[0]));
        HashMap<Integer, long[]> map = new HashMap<>();
        long sum = 0;
        long[] result = new long[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (left.contains(map.getOrDefault(nums[i], new long[2]))) {
                left.remove(map.get(nums[i]));
                sum -= nums[i] * map.get(nums[i])[0];
            }
            right.remove(map.getOrDefault(nums[i], new long[2]));
            map.put(nums[i], new long[] { map.getOrDefault(nums[i], new long[1])[0] + 1, nums[i] });
            right.add(map.get(nums[i]));
            if (i >= k - 1) {
                while (left.size() < x && !right.isEmpty()) {
                    sum += right.first()[0] * right.first()[1];
                    left.add(right.pollFirst());
                }
                result[i - k + 1] = sum;
                if (left.contains(map.getOrDefault(nums[i - k + 1], new long[2]))) {
                    left.remove(map.get(nums[i - k + 1]));
                    sum -= nums[i - k + 1] * map.get(nums[i - k + 1])[0];
                }
                right.remove(map.getOrDefault(nums[i - k + 1], new long[2]));
                map.put(nums[i - k + 1],
                        new long[] { map.getOrDefault(nums[i - k + 1], new long[1])[0] - 1, nums[i - k + 1] });
                right.add(map.get(nums[i - k + 1]));
                if (!left.isEmpty()) {
                    sum -= left.first()[0] * left.first()[1];
                    right.add(left.pollFirst());
                }
            }
        }
        return result;
    }
}