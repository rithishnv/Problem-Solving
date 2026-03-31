1class Solution {
2    public String generateString(String str1, String str2) {
3        int n = str1.length();
4        int m = str2.length();
5        int len = n + m - 1;
6        char[] ans = new char[len];
7        
8        for (int i = 0; i < n; i++) {
9            if (str1.charAt(i) == 'T') {
10                for (int j = 0; j < m; j++) {
11                    if (ans[i + j] != 0 && ans[i + j] != str2.charAt(j)) {
12                        return "";
13                    }
14                    ans[i + j] = str2.charAt(j);
15                }
16            }
17        }
18        
19        for (int i = 0; i < len; i++) {
20            if (ans[i] == 0) {
21                for (char c = 'a'; c <= 'z'; c++) {
22                    ans[i] = c;
23                    boolean valid = true;
24                    
25                    int start = Math.max(0, i - m + 1);
26                    int end = Math.min(n - 1, i);
27                    
28                    for (int j = start; j <= end; j++) {
29                        if (str1.charAt(j) == 'F') {
30                            boolean match = true;
31                            for (int k = 0; k < m; k++) {
32                                if (ans[j + k] != str2.charAt(k)) {
33                                    match = false;
34                                    break;
35                                }
36                            }
37                            if (match) {
38                                valid = false;
39                                break;
40                            }
41                        }
42                    }
43                    if (valid) {
44                        break;
45                    } else {
46                        ans[i] = 0;
47                    }
48                }
49                if (ans[i] == 0) return "";
50            }
51        }
52        
53        for (int i = 0; i < n; i++) {
54            if (str1.charAt(i) == 'F') {
55                boolean match = true;
56                for (int j = 0; j < m; j++) {
57                    if (ans[i + j] != str2.charAt(j)) {
58                        match = false;
59                        break;
60                    }
61                }
62                if (match) return "";
63            }
64        }
65        
66        return new String(ans);
67    }
68}