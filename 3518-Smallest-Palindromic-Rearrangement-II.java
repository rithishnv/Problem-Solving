class Solution {
    long LIMIT = 1000000L;
    public String smallestPalindrome(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;

        int[] half = new int[26];
        int len = 0;
        char mid = 0;
        for (int i = 0; i < 26; i++) {
            half[i] = cnt[i] / 2;
            len += half[i];
            if ((cnt[i] & 1) == 1) mid = (char) ('a' + i);
        }

        if (countWays(half, len) < k) return "";

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < len; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;
                half[c]--;
                long ways = countWays(half, len - pos - 1);
                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        StringBuilder ans = new StringBuilder(left);
        if (mid != 0) ans.append(mid);
        ans.append(new StringBuilder(left).reverse());
        return ans.toString();
    }

    private long countWays(int[] freq, int total) {
        long res = 1;
        int rem = total;

        for (int i = 0; i < 26; i++) {
            int f = freq[i];
            if (f == 0) continue;
            res = Math.min(LIMIT + 1, res * comb(rem, f));
            if (res > LIMIT) return LIMIT + 1;
            rem -= f;
        }
        return res;
    }

    private long comb(int n, int r) {
        if (r > n - r) r = n - r;
        long res = 1;
        for (int i = 1; i <= r; i++) {
            long a = n - r + i;
            long b = i;
            long g = gcd(a, b);
            a /= g;
            b /= g;

            g = gcd(res, b);
            res /= g;
            b /= g;

            if (res > LIMIT / a) return LIMIT + 1;
            res *= a;
            res /= b;

            if (res > LIMIT) return LIMIT + 1;
        }
        return res;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}