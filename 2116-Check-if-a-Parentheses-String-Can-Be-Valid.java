class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        int b = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                ++b;
            } else if (b > 0) {
                --b;
            } else {
                return false;
            }
        }
        b = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                ++b;
            } else if (b > 0) {
                --b;
            } else {
                return false;
            }
        }
        return true;
    }
}