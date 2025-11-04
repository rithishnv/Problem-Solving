class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            int[] subarray = Arrays.copyOfRange(nums, i, i + k);
            answer[i] = computeXSum(subarray, x);
        }
        
        return answer;
    }

    private int computeXSum(int[] subarray, int x) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : subarray) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> frequencyList = new ArrayList<>(frequencyMap.entrySet());
        frequencyList.sort((a, b) -> b.getValue().equals(a.getValue()) ? b.getKey() - a.getKey() : b.getValue() - a.getValue());

        int sum = 0;
        for (int i = 0; i < Math.min(x, frequencyList.size()); i++) {
            sum += frequencyList.get(i).getKey() * frequencyList.get(i).getValue();
        }
        
        return sum;
    }
}
