1class Solution {
2    class TrieNode {
3        TrieNode[] children = new TrieNode[26];
4        int bestLen = Integer.MAX_VALUE;
5        int bestIdx = Integer.MAX_VALUE;
6    }
7
8    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
9        TrieNode root = new TrieNode();
10        
11        for (int i = 0; i < wordsContainer.length; i++) {
12            String word = wordsContainer[i];
13            int len = word.length();
14            TrieNode curr = root;
15            
16            if (len < curr.bestLen || (len == curr.bestLen && i < curr.bestIdx)) {
17                curr.bestLen = len;
18                curr.bestIdx = i;
19            }
20            
21            for (int j = len - 1; j >= 0; j--) {
22                int charIdx = word.charAt(j) - 'a';
23                
24                if (curr.children[charIdx] == null) {
25                    curr.children[charIdx] = new TrieNode();
26                }
27                
28                curr = curr.children[charIdx];
29                
30                if (len < curr.bestLen || (len == curr.bestLen && i < curr.bestIdx)) {
31                    curr.bestLen = len;
32                    curr.bestIdx = i;
33                }
34            }
35        }
36        
37        int[] ans = new int[wordsQuery.length];
38        
39        for (int i = 0; i < wordsQuery.length; i++) {
40            String query = wordsQuery[i];
41            int len = query.length();
42            TrieNode curr = root;
43            
44            for (int j = len - 1; j >= 0; j--) {
45                int charIdx = query.charAt(j) - 'a';
46                if (curr.children[charIdx] == null) {
47                    break;
48                }
49                curr = curr.children[charIdx];
50            }
51            ans[i] = curr.bestIdx;
52        }
53        
54        return ans;
55    }
56} 