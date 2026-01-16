1class Solution {
2    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
3        List<Integer> hList = new ArrayList<>();
4        for (int h : hFences) hList.add(h);
5        hList.add(1);
6        hList.add(m);
7
8        List<Integer> vList = new ArrayList<>();
9        for (int v : vFences) vList.add(v);
10        vList.add(1);
11        vList.add(n);
12
13        Set<Integer> stt = new HashSet<>();
14        long ans = 0;
15
16        for (int i = 0; i < hList.size(); i++) {
17            for (int j = i + 1; j < hList.size(); j++) {
18                stt.add(Math.abs(hList.get(j) - hList.get(i)));
19            }
20        }
21
22        for (int i = 0; i < vList.size(); i++) {
23            for (int j = i + 1; j < vList.size(); j++) {
24                int val = Math.abs(vList.get(j) - vList.get(i));
25                if (stt.contains(val)) {
26                    ans = Math.max(ans, val);
27                }
28            }
29        }
30
31        if (ans == 0) {
32            return -1;
33        }
34
35        long MOD = 1_000_000_007;
36        return (int) ((ans * ans) % MOD);
37    }
38}