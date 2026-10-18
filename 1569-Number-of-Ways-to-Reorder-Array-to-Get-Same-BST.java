class Solution {
    int MOD = 1_000_000_007;
    long[][] c;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        c = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % MOD;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }
        return (int) ((count(list) - 1 + MOD) % MOD);
    }
    long count(List<Integer> list) {
        int size = list.size();
        if (size <= 2) {
            return 1;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int root = list.get(0);
        for (int i = 1; i < size; i++) {
            int x = list.get(i);
            if (x < root) {
                left.add(x);
            } else {
                right.add(x);
            }
        }
        return c[size - 1][left.size()] * count(left) % MOD * count(right) % MOD;
    }
}