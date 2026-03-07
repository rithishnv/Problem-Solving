1class Solution {
2    public int minFlips(String s) {
3        int n = s.length();
4        String t = s + s;
5        int diff1 = 0, diff2 = 0;
6        int ans = Integer.MAX_VALUE;
7
8        for (int i = 0; i < 2 * n; i++) {
9            char expect1 = (i % 2 == 0) ? '0' : '1'; 
10            char expect2 = (i % 2 == 0) ? '1' : '0'; 
11            if (t.charAt(i) != expect1) diff1++;
12            if (t.charAt(i) != expect2) diff2++;
13
14            if (i >= n) {
15                char oldExpect1 = ((i - n) % 2 == 0) ? '0' : '1';
16                char oldExpect2 = ((i - n) % 2 == 0) ? '1' : '0';
17
18                if (t.charAt(i - n) != oldExpect1) diff1--;
19                if (t.charAt(i - n) != oldExpect2) diff2--;
20            }
21
22            if (i >= n - 1) {
23                ans = Math.min(ans, Math.min(diff1, diff2));
24            }
25        }
26
27        return ans;
28    }
29}