1class Solution {
2    public int minimumDistance(int[] nums) {
3        Map<Integer,List<Integer>> map=new HashMap<>();
4        int n=nums.length;
5        for(int i=0;i<n;i++){
6            List<Integer> li=map.getOrDefault(nums[i],new ArrayList<Integer>());
7            li.add(i);
8            map.put(nums[i],li);
9        }
10        int min=Integer.MAX_VALUE;
11        for(int i:map.keySet()){
12            if(map.get(i).size()>=3){
13                List<Integer> li=map.get(i);
14                for(int j=0;j<=li.size()-3;j++){
15                    min=Math.min(min,2*Math.abs(li.get(j+2)-li.get(j)));
16                }
17            }
18        }
19        return (min==Integer.MAX_VALUE)?-1:min;
20    }
21}