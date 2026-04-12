1class Solution {
2    public int minimumDistance(String word) {
3      int n = word.length();
4      int[][] pos = new int[26][2];
5      for(int i = 0; i < 26; i++){
6        pos[i][0] = i / 6;
7        pos[i][1] = i % 6;
8      }  
9      int total = 0;
10      int[] dp = new int[26];
11      for(int i = 1; i < n; i++){
12        int prev = word.charAt(i - 1) - 'A';
13        int curr = word.charAt(i) - 'A';
14        int d = dist(pos, prev, curr);
15        total += d;
16
17        int[] next = new int[26];
18        for(int c = 0; c < 26; c++){
19            next[c] = Math.max(next[c], dp[c]);
20            int saving = d - dist(pos, c, curr);
21            next[prev] = Math.max(next[prev], dp[c] + saving);
22        }
23        dp = next;
24      }
25      int maxSave = 0;
26      for(int val : dp) maxSave = Math.max(maxSave, val);
27      return total - maxSave;
28      
29    }
30    private int dist(int[][] pos, int a, int b){
31        return Math.abs(pos[a][0] - pos[b][0]) +
32        Math.abs(pos[a][1] - pos[b][1]);
33    }
34}