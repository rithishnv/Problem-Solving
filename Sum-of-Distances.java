1class Solution {
2    public long[] distance(int[] nums) {
3        Map<Integer,List<Integer>> map=new HashMap<>();
4        int n=nums.length;
5        long[] ans=new long[n];
6        for(int i=0;i<n;i++){
7            List<Integer>li=map.getOrDefault(nums[i],new ArrayList<Integer>());
8            li.add(i);
9            map.put(nums[i],li);
10        }
11        for (List<Integer> li : map.values()) {
12            long sum = 0;
13            for (int x : li) sum += x;
14            long leftSum = 0;
15            int m = li.size();
16            for (int i = 0; i < m; i++) {
17                long rightSum = sum - leftSum - li.get(i);
18                long left  = (long) li.get(i) * i - leftSum;
19                long right = rightSum - (long) li.get(i) * (m - i - 1);
20                ans[li.get(i)] = left + right;
21                leftSum += li.get(i);
22            }
23        }
24
25        return ans;
26    }
27}