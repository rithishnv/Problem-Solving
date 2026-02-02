1class Solution {
2    public long minimumCost(int[] nums, int k, int dist) {
3    TreeSet<Integer> currset =new TreeSet<>((a,b)->nums[a]!=nums[b]?nums[a]-nums[b]:a-b);
4    TreeSet<Integer> futset = new TreeSet<>((a,b)->nums[a]!=nums[b]?nums[a]-nums[b]:a-b);
5        long cost = Long.MAX_VALUE;
6        int n = nums.length;
7        long currsum = 0l; 
8
9        for(int i=1; i<=dist+1; i++) {
10            currset.add(i);
11            currsum += nums[i];
12        }
13        while(currset.size() > k-1) {
14            int ind = currset.pollLast();
15            currsum -= nums[ind];
16            futset.add(ind);
17        }
18        cost = currsum;
19        for(int i=1; i < n-1-dist; i++) {
20            int rightInd = i+dist+1;
21            int leftInd = i;
22           
23            if(currset.contains(leftInd)) {
24                currsum -= nums[leftInd];
25                currset.remove(leftInd);
26                currsum += nums[rightInd];
27                currset.add(rightInd);
28            }
29            else {
30                futset.remove(leftInd);
31                futset.add(rightInd);
32            }
33
34            if(futset.size() > 0) {
35                int minF = futset.first();
36                int maxC = currset.last();
37                if(nums[minF] < nums[maxC]) {
38                    currsum -= nums[maxC];
39                    currset.remove(maxC);
40                    currset.add(minF);
41                    currsum += nums[minF];
42                    futset.remove(minF);
43                    futset.add(maxC);
44                }
45            }
46            cost = Math.min(cost, currsum);
47        }
48        return cost + nums[0];
49    }
50}