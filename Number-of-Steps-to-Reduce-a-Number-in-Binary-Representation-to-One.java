1class Solution {
2    public int numSteps(String s) {
3        int res = 0, carry = 0;
4        for (int i = s.length() - 1; i > 0; --i) {
5            ++res;
6            if (s.charAt(i) - '0' + carry == 1) {
7                carry = 1;
8                ++res;
9            }
10        }
11        return res + carry;
12    }
13}