1class SegmentTree {
2    public int n, size;
3    public int[] sum, mn, mx;
4
5    SegmentTree(int n) {
6        this.n = n;
7        this.size = 4 * n;
8        this.sum = new int[size];
9        this.mn  = new int[size];
10        this.mx  = new int[size];
11    }
12
13    void pull(int node) {
14        int l = node * 2, r = node * 2 + 1;
15
16        sum[node] = sum[l] + sum[r];
17        mn[node] = Math.min(mn[l], sum[l] + mn[r]);
18        mx[node] = Math.max(mx[l], sum[l] + mx[r]);
19    }
20
21    void update(int idx, int val) {
22        int node = 1, l = 0, r = n - 1, index = 0;
23        int[] path = new int[32]; 
24
25        while (l != r) {
26            path[index++] = node;
27            int m = l + (r - l) / 2;
28            if (idx <= m) {
29                node = node * 2;
30                r = m;
31            } else {
32                node = node * 2 + 1;
33                l = m + 1;
34            }
35        }
36
37        sum[node] = val;
38        mn[node] = val;
39        mx[node] = val;
40
41        while (index > 0) {
42            pull(path[--index]);
43        }
44    }
45
46    int find_rightmost_prefix(int target) {
47        int node = 1, l = 0, r = n - 1, sum_before = 0;
48
49        if (target < mn[node] || target > mx[node]) return -1;
50
51        while (l != r) {
52            int m = l + (r - l) / 2;
53            int lchild = node * 2, rchild = node * 2 + 1;
54
55            int sum_before_right = sum[lchild] + sum_before;
56            int need_right = target - sum_before_right;
57
58            if (mn[rchild] <= need_right && need_right <= mx[rchild]) {
59                node = rchild;
60                l = m + 1;
61                sum_before = sum_before_right;
62            } else {
63                node = lchild;
64                r = m;
65            }
66        }
67
68        return l;
69    }
70}
71
72class Solution {
73    public int longestBalanced(int[] nums) {
74        int n = nums.length;
75        SegmentTree s_tree = new SegmentTree(n);
76    
77        int[] first = new int[100001]; 
78        Arrays.fill(first, -1);
79        
80        int result = 0;
81        for (int l = n - 1; l >= 0; --l) {
82            int num = nums[l];
83            
84            if (first[num] != -1) {
85                s_tree.update(first[num], 0);
86            }
87            first[num] = l;
88            
89            s_tree.update(l, (num & 1) == 0 ? 1 : -1); 
90            
91            int r = s_tree.find_rightmost_prefix(0);
92            if (r >= l) {
93                result = Math.max(result, r - l + 1);
94            }
95        }
96        
97        return result;
98    }
99}