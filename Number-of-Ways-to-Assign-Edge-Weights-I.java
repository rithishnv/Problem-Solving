1class Solution {
2    public int assignEdgeWeights(int[][] edges) {
3        int mod=1000000007;
4        Map<Integer,List<Integer>> map=new HashMap<>();
5        Set<Integer> set=new HashSet<>();
6        for(int[] i:edges){
7            map.putIfAbsent(i[0],new ArrayList<Integer>());
8            map.get(i[0]).add(i[1]);
9            set.add(i[1]);
10        }
11        int root=-1;
12        for(int[] i:edges){
13            if(!set.contains(i[0])){
14                root=i[0];
15                break;
16            }
17        }
18        int depth=dfs(root,map);
19        int res=1;
20        for(int i=0;i<depth-1;i++){
21            res=(res*2)%mod;
22        }
23        return res;
24    }
25    public int dfs(int root,Map<Integer,List<Integer>> map){
26        if(!map.containsKey(root)){
27            return 0;
28        }
29        int m=0;
30        for(int i:map.get(root)){
31            m=Math.max(m,1+dfs(i,map));
32        }
33        return m;
34    }
35}