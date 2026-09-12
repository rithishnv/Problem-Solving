class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] a = new int[n][4];
        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }
        Arrays.sort(a, (x, y) -> {
            if (x[0] != y[0]) return x[0] - y[0];
            if (x[1] != y[1]) return x[1] - y[1];
            if (x[2] != y[2]) return x[2] - y[2];
            return x[3] - y[3];
        });
        int[] ls = new int[n];
        for (int i = 0; i < n; i++) ls[i] = a[i][0];

        long[][] s = new long[n+1][5];
        List<Integer>[][] p = new List[n+1][5];
        for (int k = 0; k <= 4; k++) p[n][k] = new ArrayList<>();

        for (int i = n-1; i >= 0; i--) {
            int nx = upperBound(ls, a[i][1]);
            for (int k = 0; k <= 4; k++) p[i][k] = p[i+1][k];
            for (int k = 1; k <= 4; k++) {
                s[i][k] = s[i+1][k];
                long t = (long) a[i][2] + s[nx][k-1];
                List<Integer> q = new ArrayList<>(p[nx][k-1]);
                q.add(a[i][3]);
                Collections.sort(q);
                if (t > s[i][k] || (t == s[i][k] && isLexSmaller(q, p[i][k]))) {
                    s[i][k] = t;
                    p[i][k] = q;
                }
            }
        }

        int[] ans = new int[p[0][4].size()];
        for (int i = 0; i < ans.length; i++) ans[i] = p[0][4].get(i);
        return ans;
    }

    private int upperBound(int[] ls, int val) {
        int lo = 0, hi = ls.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (ls[mid] <= val) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private boolean isLexSmaller(List<Integer> a, List<Integer> b) {
        int n = Math.min(a.size(), b.size());
        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) return a.get(i) < b.get(i);
        }
        return a.size() < b.size();
    }
}