1
2class Solution {
3    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
4        int[] groups = new int[n];
5        List<Integer> result = new ArrayList<>();
6        List<Integer> temp = new ArrayList<>();
7
8        for (int i = 0; i < n; ++i) groups[i] = i;
9        groups[firstPerson] = 0;
10
11        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));
12
13        int i = 0;
14        while (i < meetings.length) {
15            int currentTime = meetings[i][2];
16            temp.clear();
17            while (i < meetings.length && meetings[i][2] == currentTime) {
18                int g1 = find(groups, meetings[i][0]);
19                int g2 = find(groups, meetings[i][1]);
20                groups[Math.max(g1, g2)] = Math.min(g1, g2);
21                temp.add(meetings[i][0]);
22                temp.add(meetings[i][1]);
23                ++i;
24            }
25            for (int j = 0; j < temp.size(); ++j) {
26                if (find(groups, temp.get(j)) != 0) {
27                    groups[temp.get(j)] = temp.get(j);
28                }
29            }
30        }
31
32        for (int j = 0; j < n; ++j) {
33            if (find(groups, j) == 0) result.add(j);
34        }
35
36        return result;
37    }
38
39    private int find(int[] groups, int index) {
40        while (index != groups[index]) index = groups[index];
41        return index;
42    }
43}