1class Solution {
2    public int maxDistance(int[] colors) {
3        int res=0;
4        int n=colors.length;
5        Set<Integer> set=new HashSet<>();
6        for(int i=0;i<n;i++){
7            if(set.contains(colors[i]))
8            continue;
9            set.add(colors[i]);
10            for(int j=i+1;j<n;j++){
11                if(colors[i]!=colors[j]){
12                    res=Math.max(res,j-i);
13                }
14            }
15        }
16        return res;
17    }
18}