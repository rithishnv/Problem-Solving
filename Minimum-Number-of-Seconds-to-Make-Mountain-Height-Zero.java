1class Solution {
2    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
3        PriorityQueue<long[]> pq = new PriorityQueue<>(
4            (a, b) -> Long.compare(a[0], b[0])
5        );
6        for (int t : workerTimes) {
7            pq.offer(new long[]{t, t, 1});
8        }
9        while (mountainHeight > 1) {
10            long[] cur = pq.poll();
11            long ps = cur[0];  
12            long wt = cur[1];  
13            long x  = cur[2];
14            long nextTime = ps + wt * (x + 1);
15            pq.offer(new long[]{nextTime, wt, x + 1});
16            mountainHeight--;
17        }
18        return pq.poll()[0];
19    }
20}