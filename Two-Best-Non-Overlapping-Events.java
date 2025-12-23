1class Solution {
2    public int maxTwoEvents(int[][] events) 
3    {
4        Arrays.sort(events , (a,b)-> a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
5        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
6        
7        int max = 0 , ans = 0;
8        pq.add(new int[]{events[0][1] , events[0][2]});
9        
10        for(int i=1 ; i<events.length ; i++)
11        {
12            while(!pq.isEmpty() && pq.peek()[0]<events[i][0])
13            {
14                int a[] = pq.poll();
15                max = Math.max(max , a[1]);
16            }
17            ans = Math.max(ans , max + events[i][2]);
18            pq.add(new int[]{events[i][1] , events[i][2]});
19        }
20        while(!pq.isEmpty())
21        {
22            ans = Math.max(ans , pq.poll()[1]);
23        }
24        
25        return ans;
26    }
27}