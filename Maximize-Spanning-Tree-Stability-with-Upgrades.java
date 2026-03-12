1class Solution {
2
3    class DSU{
4        int[] parent,rank;
5
6        DSU(int n){
7            parent=new int[n];
8            rank=new int[n];
9
10            for(int i=0;i<n;i++)
11                parent[i]=i;
12        }
13
14        int find(int x){
15            if(parent[x]==x) return x;
16            return parent[x]=find(parent[x]);
17        }
18
19        boolean union(int a,int b){
20            a=find(a);
21            b=find(b);
22
23            if(a==b) return false;
24
25            if(rank[a]<rank[b]){
26                int t=a;
27                a=b;
28                b=t;
29            }
30
31            parent[b]=a;
32
33            if(rank[a]==rank[b]) rank[a]++;
34
35            return true;
36        }
37    }
38
39    public int maxStability(int n, int[][] edges, int k) {
40
41        DSU dsu=new DSU(n);
42
43        int comp=n;
44        int mandatoryMin=Integer.MAX_VALUE;
45
46        List<int[]> optional=new ArrayList<>();
47
48        for(int[] e:edges)
49        {
50            if(e[3]==1)
51            {
52                if(!dsu.union(e[0],e[1])) return -1;
53
54                comp--;
55                mandatoryMin=Math.min(mandatoryMin,e[2]);
56            }
57            else optional.add(e);
58        }
59
60        optional.sort((a,b)->b[2]-a[2]);
61
62        List<Integer> used=new ArrayList<>();
63
64        for(int[] e:optional)
65        {
66            if(dsu.union(e[0],e[1]))
67            {
68                used.add(e[2]);
69                comp--;
70                if(comp==1) break;
71            }
72        }
73
74        if(comp>1) return -1;
75
76        Collections.sort(used);
77
78        int ans=mandatoryMin;
79
80        for(int w:used)
81        {
82            int val=w;
83
84            if(k>0)
85            {
86                val*=2;
87                k--;
88            }
89
90            if(ans==Integer.MAX_VALUE) ans=val;
91            else ans=Math.min(ans,val);
92        }
93
94        return ans;
95    }
96}