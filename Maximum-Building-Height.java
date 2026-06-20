1class Solution {
2    public int maxBuilding(int n, int[][] restrictions) {
3        int m = restrictions.length;
4        int[][] arr = new int[m + 2][2];
5        arr[0] = new int[]{1, 0};
6        for (int i = 0; i < m; i++) arr[i + 1] = restrictions[i];
7        arr[m + 1] = new int[]{n, n - 1};
8        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
9        for (int i = 1; i < arr.length; i++) {
10            int dist = arr[i][0] - arr[i - 1][0];
11            arr[i][1] = Math.min(arr[i][1], arr[i - 1][1] + dist);
12        }
13        for (int i = arr.length - 2; i >= 0; i--) {
14            int dist = arr[i + 1][0] - arr[i][0];
15            arr[i][1] = Math.min(arr[i][1], arr[i + 1][1] + dist);
16        }
17        int ans = 0;
18        for (int i = 1; i < arr.length; i++) {
19            int dist = arr[i][0] - arr[i - 1][0];
20            int diff = Math.abs(arr[i][1] - arr[i - 1][1]);
21            int peak = Math.max(arr[i][1], arr[i - 1][1]) + (dist - diff) / 2;
22            ans = Math.max(ans, peak);
23        }
24        return ans;
25    }
26}