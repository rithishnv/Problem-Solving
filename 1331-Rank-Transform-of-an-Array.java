class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] temp = arr.clone();
        Arrays.sort(temp);
        int idx = 1;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!mp.containsKey(temp[i])) {
                mp.put(temp[i], idx++);
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = mp.get(arr[i]);
        }
        return arr;
    }
}