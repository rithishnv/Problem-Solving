class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        mx <<= 1;
        boolean[] pairXor = new boolean[mx];
        for (int a : nums) {
            for (int b : nums) {
                pairXor[a ^ b] = true;
            }
        }
        boolean[] ans = new boolean[mx];
        for (int x = 0; x < mx; x++) {
            if (!pairXor[x]) continue;

            for (int c : nums) {
                ans[x ^ c] = true;
            }
        }
        int res = 0;
        for (boolean b : ans) {
            if (b) res++;
        }
        return res;
    }
}