1class Solution {
2    public int minJumps(int[] nums) {
3        int n=nums.length;
4
5        Map<Integer,List<Integer>> map=new HashMap<>();
6
7        for(int i=0;i<n;i++){
8            int num=nums[i];
9            if(!map.containsKey(num)){
10                map.put(num,new ArrayList<>());
11                map.get(num).add(i);
12            }else{
13                map.get(num).add(i);
14            }
15        }
16        Queue<Integer> queue=new ArrayDeque<>();
17        boolean[] vis=new boolean[n];
18
19        queue.offer(0);
20        vis[0]=true;
21
22        int steps=0;
23
24        while(!queue.isEmpty()){
25            int size=queue.size();
26            for(int i=0;i<size;i++){
27                int idx=queue.poll();
28                if(idx==n-1){
29                    return steps;
30                }
31                if(idx-1>=0 && !vis[idx-1]){
32                    queue.offer(idx-1);
33                    vis[idx-1]=true;
34                }
35                if(idx+1<n && !vis[idx+1]){
36                    queue.offer(idx+1);
37                    vis[idx+1]=true;
38                }
39                if(map.containsKey(nums[idx])){
40                    for(int num:map.get(nums[idx])){
41                        if(!vis[num]){
42                            queue.offer(num);
43                            vis[num]=true;
44                        }
45                    }
46                    map.remove(nums[idx]);
47                }
48            }
49            steps++;
50
51        }
52        return steps;
53    }
54}