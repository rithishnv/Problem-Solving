1class Solution {
2    public int countBinarySubstrings(String s) {
3        int cur = 1, pre = 0, res = 0;
4        for (int i = 1; i < s.length(); i++) {
5            if (s.charAt(i) == s.charAt(i - 1)) cur++;
6            else {
7                res += Math.min(cur, pre);
8                pre = cur;
9                cur = 1;
10            }
11        }
12        return res + Math.min(cur, pre);
13    }
14}