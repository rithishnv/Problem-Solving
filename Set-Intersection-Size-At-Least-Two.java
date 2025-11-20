class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]); 
        List<Integer> res = new ArrayList<>();
        res.add(intervals[0][1] - 1); 
        res.add(intervals[0][1]); 
        for (int i = 1; i < n; i++) { 
            int s = intervals[i][0], e = intervals[i][1], size = res.size(), l = res.get(size - 1), secondl = res.get(size - 2);
            if (s > l) { 
                res.add(e - 1);
                res.add(e);
            } else if (s == l) res.add(e); 
            else if (s > secondl) res.add(e); 
        }
        return res.size();
    }
}