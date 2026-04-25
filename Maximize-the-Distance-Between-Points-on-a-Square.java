1class Solution {
2    public int maxDistance(int side, int[][] points, int k) {
3        long[] res = new long[points.length];
4        long lSide = (long) side;
5
6        for (int i = 0; i < points.length; i++) {
7            long x = points[i][0];
8            long y = points[i][1];
9            if (x == 0) res[i] = y;
10            else if (y == lSide) 
11                res[i] = lSide + x;
12            else if (x == lSide) 
13                res[i] = lSide * 3 - y;
14            else res[i] = lSide * 4 - x;
15        }
16        Arrays.sort(res);
17
18        int left = 1;
19        int right = (int) ((lSide * 4) / k) + 1;
20        
21        while (left + 1 < right) {
22            int mid = left + (right - left) / 2;
23            if (check(mid, res, lSide, k)) 
24                left = mid;
25            else right = mid;
26        }
27        return left;
28    }
29
30    private boolean check(int n, long[] res, long lSide, int k) {
31        int m = res.length;
32        int[] idx = new int[k];
33        long perimeter = lSide * 4;
34        
35        idx[0] = 0;
36        long curr = res[0];
37        for (int i = 1; i < k; i++) {
38            int pos = Arrays.binarySearch(res, curr + n);
39            if (pos < 0) 
40                pos = -(pos + 1);
41            if (pos == m) 
42                return false;
43            idx[i] = pos;
44            curr = res[pos];
45        }
46        
47        if (res[idx[k - 1]] - res[0] <= perimeter - n) 
48            return true;
49
50        for (idx[0] = 1; idx[0] < idx[1]; idx[0]++) {
51            for (int j = 1; j < k; j++) {
52                while (idx[j] < m && res[idx[j]] < res[idx[j - 1]] + n) {
53                    idx[j]++;
54                }
55                if (idx[j] == m) 
56                    return false;
57            }
58            if (res[idx[k - 1]] - res[idx[0]] <= perimeter - n) 
59                return true;
60        }
61        return false;
62    }
63}