1class Solution {
2    public boolean canReach(int[] arr, int start) {
3        int n=arr.length;
4        Queue<Integer> q=new LinkedList<>();
5        boolean[] v=new boolean[n];
6        q.add(start);
7        while(!q.isEmpty()){
8            int len=q.size();
9            for(int i=0;i<len;i++){
10                int a=q.poll();
11                v[a]=true;
12                if(arr[a]==0){
13                    return true;
14                }
15                int a1=a+arr[a];
16                int a2=a-arr[a];
17                if(a1>=0 && a1<n && !v[a1]){
18                    q.add(a1);
19                }
20                if(a2>=0 && a2<n && !v[a2]){
21                    q.add(a2);
22                }
23            }
24        }
25        return false;
26    }
27}