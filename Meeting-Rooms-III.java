1class Solution {
2    public int mostBooked(int n, int[][] meetings) {
3        int[] count = new int[n];       
4        long[] busy = new long[n];     
5
6        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
7
8        for (int[] meeting : meetings) {
9            int start = meeting[0], end = meeting[1];
10            long earliest = Long.MAX_VALUE;
11            int roomIndex = -1;
12            boolean assigned = false;
13
14            for (int i = 0; i < n; i++) {
15                if (busy[i] < earliest) {
16                    earliest = busy[i];
17                    roomIndex = i;
18                }
19                if (busy[i] <= start) {
20                    busy[i] = end;
21                    count[i]++;
22                    assigned = true;
23                    break;
24                }
25            }
26
27            if (!assigned) {
28                busy[roomIndex] += (end - start);
29                count[roomIndex]++;
30            }
31        }
32
33        int max = 0, res = 0;
34        for (int i = 0; i < n; i++) {
35            if (count[i] > max) {
36                max = count[i];
37                res = i;
38            }
39        }
40        return res;
41    }
42}