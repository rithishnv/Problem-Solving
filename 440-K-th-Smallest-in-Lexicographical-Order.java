class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--;
        while (k > 0) {
            int count = getCount(current, n);
            if (count <= k) {
                current++;
                k -= count;
            } else {
                current *= 10; 
                k--; 
            }
        }
        return current;
    }
    private int getCount(long prefix, int n) {
        long nextPrefix = prefix + 1;
        int count = 0;
        while (prefix <= n) {
            count += Math.min(n + 1, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }   
        return count;
    }
}