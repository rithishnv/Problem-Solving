class Solution {
    public int minimumPushes(String word) {
        int t = 1, s = 0;
        int n = word.length();
        while (n >= 8) {
            s += 8 * t;
            n -= 8;
            t++;
        }
        s += (n * t);
        return s;
    }
}