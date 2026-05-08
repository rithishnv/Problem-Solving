1class Solution {
2    boolean[] isPrime;
3
4    public int minJumps(int[] nums) {
5        int n = nums.length;
6        int maxi = nums[0];
7        HashMap<Integer, List<Integer>> map = new HashMap<>();
8
9        for (int i = 0; i < n; i++) {
10            int val = nums[i];
11            map.putIfAbsent(val, new ArrayList<>());
12            map.get(val).add(i);
13            maxi = Math.max(maxi, val);
14        }
15
16        isPrime = new boolean[maxi + 1];
17        sieve(maxi);
18
19        Queue<Integer> q = new LinkedList<>();
20        boolean[] vis = new boolean[n];
21        HashSet<Integer> usedPrime = new HashSet<>();
22
23        q.offer(0);
24        vis[0] = true;
25
26        int steps = 0;
27
28        while (!q.isEmpty()) {
29            int size = q.size();
30
31            while (size-- > 0) {
32                int idx = q.poll();
33
34                if (idx == n - 1) {
35                    return steps;
36                }
37
38                if (idx - 1 >= 0 && !vis[idx - 1]) {
39                    vis[idx - 1] = true;
40                    q.offer(idx - 1);
41                }
42
43                if (idx + 1 < n && !vis[idx + 1]) {
44                    vis[idx + 1] = true;
45                    q.offer(idx + 1);
46                }
47
48                int currentValue = nums[idx];
49
50                if (isPrime[currentValue] || usedPrime.contains(currentValue)) {
51                    continue;
52                }
53
54                for (int multiple = currentValue; multiple <= maxi; multiple += currentValue) {
55                    if (!map.containsKey(multiple)) {
56                        continue;
57                    }
58
59                    for (int nextIndex : map.get(multiple)) {
60                        if (!vis[nextIndex]) {
61                            vis[nextIndex] = true;
62                            q.offer(nextIndex);
63                        }
64                    }
65                }
66
67                usedPrime.add(currentValue);
68            }
69
70            steps++;
71        }
72
73        return -1;
74    }
75
76    private void sieve(int size) {
77        if (size >= 0) {
78            isPrime[0] = true;
79        }
80
81        if (size >= 1) {
82            isPrime[1] = true;
83        }
84
85        for (int i = 2; i * i <= size; i++) {
86            if (!isPrime[i]) {
87                for (int j = i * i; j <= size; j += i) {
88                    isPrime[j] = true;
89                }
90            }
91        }
92    }
93}