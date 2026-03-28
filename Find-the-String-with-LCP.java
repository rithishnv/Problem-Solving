1class Solution {
2    public String findTheString(int[][] lcp) {
3        int n = lcp.length; int[] word = new int[n]; word[0] = 0;  
4
5        for (int i = 1; i < n; i++) {
6            int forbidden_mask = 0, assigned = -1;
7            for (int j = 0; j < i; j++) {
8                if (lcp[i][j] > 0) {
9                    assigned = word[j];
10                    break;
11                } else if (lcp[i][j] == 0) {
12                    forbidden_mask |= 1 << word[j];
13                }
14            }
15
16            if (assigned != -1) {
17                word[i] = assigned;
18            } else {
19                int letter = 0;
20                while (letter < 26 && ((forbidden_mask >> letter) & 1) == 1) letter++;
21                if (letter >= 26) return "";
22                word[i] = letter;
23            }
24        }
25
26        for (int i = n - 1; i >= 0; i--) {
27            for (int j = n - 1; j >= 0; j--) {
28                if (word[i] != word[j]) {
29                    if (lcp[i][j] != 0) return "";
30                } else {
31                    if (i == n - 1 || j == n - 1) {
32                        if (lcp[i][j] != 1) return "";
33                    } else {
34                        if (lcp[i][j] != lcp[i + 1][j + 1] + 1) return "";
35                    }
36                }
37            }
38        }
39
40        char[] res = new char[n];
41        for (int i = 0; i < n; i++) {
42            res[i] = (char)('a' + word[i]);
43        }
44        
45        return new String(res);
46    }
47}