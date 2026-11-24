class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            long prod = 1, g = 0, l = 1;
            for (int j = i; j < n; j++) {
                prod *= nums[j];
                g = gcd(g, nums[j]);
                l = lcm(l , nums[j]);
                if (prod == (l * g))
                    res = Math.max(res, j - i + 1);
            }
        }
        return res;

    }

    public long lcm(long a, long b) {
        return (a / gcd(a, b) * b);
    }

    public long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a ;
    }
}