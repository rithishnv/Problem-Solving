1class Solution {
2    public long[] distance(int[] nums) {
3        Map<Integer,List<Integer>> map=new HashMap<>();
4        int n=nums.length;
5        long[] res=new long[n];
6        for(int i=0;i<n;i++){
7            List<Integer>li=map.getOrDefault(nums[i],new ArrayList<Integer>());
8            li.add(i);
9            map.put(nums[i],li);
10        }
11        for(int i=0;i<n;i++){
12            List<Integer>li=map.get(nums[i]);
13            for(int j:li){
14                if(j!=i){
15                    res[i]+=Math.abs(i-j);
16                }
17            }
18        }
19        return res;
20    }
21}