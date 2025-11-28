1class Solution {
2    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
3        List<ArrayList<Integer>> li=new ArrayList<>();
4        for(int i=0;i<n;i++){
5            li.add(new ArrayList<Integer>());
6        }
7        for(int[] e:edges){
8            li.get(e[0]).add(e[1]);
9            li.get(e[1]).add(e[0]);
10        }
11        int[] cnt=new int[n];
12        Queue<Integer> q=new LinkedList<>();
13        for(int i=0;i<n;i++){
14            cnt[i]=li.get(i).size();
15            if(cnt[i]<2)
16            q.add(i);
17        }
18        int res=0;
19        while(!q.isEmpty()){
20            int i=q.poll();
21            cnt[i]--;
22            if(values[i]%k==0)
23            res++;
24            for(int j:li.get(i)){
25                if(cnt[j]!=0){
26                    values[j]=(values[j]+values[i]%k)%k;
27                    if(--cnt[j]==1)
28                    q.add(j);
29                }
30            }
31        }
32        return res;
33    }
34}