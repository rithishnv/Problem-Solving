1class Solution {
2    class Pair {
3        long sum;
4        int left_idx;
5        
6        Pair(long sum, int left_idx) {
7            this.sum = sum;
8            this.left_idx = left_idx;
9        }
10    }
11    
12    public int minimumPairRemoval(int[] nums) {
13        int n = nums.length;
14        if (n <= 1) return 0;
15        
16        boolean already_sorted = true;
17        for (int i = 1; i < n; i++) {
18            if (nums[i] < nums[i - 1]) {
19                already_sorted = false;
20                break;
21            }
22        }
23        if (already_sorted) return 0;
24        
25        long[] arr = new long[n];
26        for (int i = 0; i < n; i++) {
27            arr[i] = nums[i];
28        }
29        
30        boolean[] removed = new boolean[n];
31        
32        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
33            public int compare(Pair a, Pair b) {
34                if (a.sum < b.sum) return -1;
35                if (a.sum > b.sum) return 1;
36                return Integer.compare(a.left_idx, b.left_idx);
37            }
38        });
39        
40        int sorted_pairs = 0;
41        for (int i = 1; i < n; i++) {
42            pq.add(new Pair(arr[i - 1] + arr[i], i - 1));
43            if (arr[i] >= arr[i - 1]) sorted_pairs++;
44        }
45        
46        if (sorted_pairs == n - 1) return 0;
47        
48        int[] prev = new int[n], next = new int[n];
49        for (int i = 0; i < n; i++) {
50            prev[i] = i - 1;
51            next[i] = i + 1;
52        }
53        
54        int remaining = n, operations = 0;
55        while (remaining > 1) {
56            Pair top = pq.poll();
57            if (top == null) break;
58            
59            long sum = top.sum;
60            int left = top.left_idx, right = next[left];
61            
62            if (right >= n || removed[left] || removed[right] || 
63                arr[left] + arr[right] != sum) {
64                continue;
65            }
66            
67            int pre = prev[left], nxt = next[right];
68            
69            if (arr[left] <= arr[right]) sorted_pairs--;
70            if (pre != -1 && arr[pre] <= arr[left]) sorted_pairs--;
71            if (nxt != n && arr[right] <= arr[nxt]) sorted_pairs--;
72            
73            arr[left] = sum;
74            removed[right] = true;
75            remaining--;
76            operations++;
77            
78            if (pre != -1) {
79                pq.add(new Pair(arr[pre] + arr[left], pre));
80                if (arr[pre] <= arr[left]) sorted_pairs++;
81                next[pre] = left;
82                prev[left] = pre;
83            } else {
84                prev[left] = -1;
85            }
86            
87            if (nxt != n) {
88                prev[nxt] = left;
89                next[left] = nxt;
90                pq.add(new Pair(arr[left] + arr[nxt], left));
91                if (arr[left] <= arr[nxt]) sorted_pairs++;
92            } else {
93                next[left] = n;
94            }
95
96            if (sorted_pairs == remaining - 1) {
97                return operations;
98            }
99        }
100        
101        return operations;
102    }
103}