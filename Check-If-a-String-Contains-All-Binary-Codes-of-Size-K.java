1class Solution {
2    public boolean hasAllCodes(String s, int k) {
3        Set<String> seen = new HashSet<>();
4        for (int i = 0; i <= s.length() - k; i++) {
5        seen.add(s.substring(i, i + k));
6        }
7        return seen.size() == Math.pow(2,k);
8    }
9}