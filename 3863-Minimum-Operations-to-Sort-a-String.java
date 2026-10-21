class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean st = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                st = false;
                break;
            }
        }
        if (st) {
            return 0;
        }
        if (n == 2) {
            return -1;
        }
        char min = 'z', max = 'a';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < min) {
                min = c;
            }
            if (c > max) {
                max = c;
            }
        }
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }
        if (s.indexOf(min) < n - 1 || s.lastIndexOf(max) > 0) {
            return 2;
        }
        return 3;
    }
}