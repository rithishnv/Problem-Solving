1class Solution {
2    public List<Integer> solveQueries(int[] nums, int[] queries) {
3        List<Integer> res=new ArrayList<>();
4        Map<Integer,List<Integer>> map=new HashMap<>();
5        int n=nums.length;
6        for(int i=0;i<n;i++){
7            List<Integer> l=map.getOrDefault(nums[i],new ArrayList<Integer>());
8            l.add(i);
9            map.put(nums[i],l);
10        }
11        for (int ind : queries) 
12        {
13            int val = nums[ind];
14            List<Integer> pos = map.get(val);
15
16            if (pos.size() == 1) 
17            {
18                res.add(-1);
19                continue;
20            }
21
22            int idx = Collections.binarySearch(pos, ind);
23
24            int left = pos.get((idx - 1 + pos.size()) % pos.size());
25            int right = pos.get((idx + 1) % pos.size());
26
27            int d1 = Math.abs(ind - left);
28            int d2 = Math.abs(ind - right);
29
30            d1 = Math.min(d1, n - d1);
31            d2 = Math.min(d2, n - d2);
32
33            res.add(Math.min(d1, d2));
34        }
35
36        return res;
37    }
38}