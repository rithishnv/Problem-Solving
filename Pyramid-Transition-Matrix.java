1class Solution {
2    public boolean pyramidTransition(String bottom, List<String> allowed) {
3        List<Character>[][] map = new List[6][6];
4        Map<String, Boolean> memo = new HashMap<>();
5        
6        for (String al : allowed) {
7            int a = al.charAt(0) - 'A';
8            int b = al.charAt(1) - 'A';
9            if (map[a][b] == null) map[a][b] = new ArrayList<>();
10            map[a][b].add(al.charAt(2));
11        }
12        
13        return dfs(bottom.toCharArray(), map, memo);
14    }
15    
16    private boolean dfs(char[] row, List<Character>[][] map, Map<String, Boolean> memo) {
17        int n = row.length;
18        if (n == 1) return true;
19        
20        String key = new String(row);
21        if (memo.containsKey(key)) return memo.get(key);
22        
23        List<char[]> nextRows = new ArrayList<>();
24        getNextRows(row, map, 0, new char[n-1], nextRows);
25        
26        for (char[] next : nextRows) {
27            if (dfs(next, map, memo)) {
28                memo.put(key, true);
29                return true;
30            }
31        }
32        
33        memo.put(key, false);
34        return false;
35    }
36    
37    private void getNextRows(char[] row, List<Character>[][] map, int idx, 
38                            char[] current, List<char[]> result) {
39        if (idx == row.length - 1) {
40            result.add(current.clone());
41            return;
42        }
43        
44        int a = row[idx] - 'A';
45        int b = row[idx + 1] - 'A';
46        
47        if (map[a][b] == null) return;
48        
49        for (char c : map[a][b]) {
50            current[idx] = c;
51            getNextRows(row, map, idx + 1, current, result);
52        }
53    }
54}