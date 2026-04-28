1class Solution {
2    public int minOperations(int[][] grid, int x) {
3        int max=0;
4        List<Integer> li=new ArrayList<>();
5        int a=grid[0][0]%x;
6        for(int[] i:grid){
7            for(int j:i){
8                if(j%x!=a)
9                return -1;
10                li.add(j);
11            }
12        }
13        Collections.sort(li);
14        int t=li.get(li.size()/2);
15        int cnt=0;
16        for(int[] i:grid){
17            for(int j:i){
18                cnt+=Math.abs(j-t)/x;
19            }
20        }
21        return cnt;
22    }
23}