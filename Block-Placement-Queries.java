1class Solution {
2    public List<Boolean> getResults(int[][] queries) {
3        List<Boolean> ans = new ArrayList<>();
4        TreeSet<Integer> set = new TreeSet<>();
5        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>(Collections.reverseOrder());
6        set.add(0);
7        set.add(Integer.MAX_VALUE);
8        map.put(Integer.MAX_VALUE, new TreeSet<>());
9        map.get(Integer.MAX_VALUE).add(0);
10        for (int[] q : queries) {
11            if (q[0] == 1) {
12                int v1 = set.lower(q[1]);
13                int v2 = set.higher(q[1]);
14                int si = v2 - v1;
15                map.get(si).remove(v1);
16                if (map.get(si).isEmpty())
17                    map.remove(si);
18                if (!map.containsKey(q[1] - v1))
19                    map.put(q[1] - v1, new TreeSet<>());
20                if (!map.containsKey(v2 - q[1]))
21                    map.put(v2 - q[1], new TreeSet<>());
22                map.get(q[1] - v1).add(v1);
23                map.get(v2 - q[1]).add(q[1]);
24                set.add(q[1]);
25            } else {
26                int x = q[1];
27                int sz = q[2];
28                boolean f = false;
29                for (int e : map.keySet()) {
30                    if (e < sz)
31                        break;
32                    TreeSet<Integer> s = map.get(e);
33                    Integer ele = s.floor(x - sz);
34                    if (ele != null) {
35                        f = true;
36                        break;
37                    }
38                }
39                ans.add(f);
40            }
41        }
42        return ans;
43    }
44}