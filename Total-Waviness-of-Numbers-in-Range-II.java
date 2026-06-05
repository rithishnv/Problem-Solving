1class Solution {
2    Long  dp[][][][][][];
3    public long totalWaviness(long num1, long num2) {
4        dp=new Long[16][2][2][11][11][16];
5        long c1=f(0,1,0,-1,-1,0,Long.toString(num1-1));
6        dp=new Long[16][2][2][11][11][16];
7    
8        long c2=f(0,1,0,-1,-1,0,Long.toString(num2));
9        return c2-c1;
10    }
11    public long f(int index,int tight,int validnum,int last2,int last1,int sc,String s){
12        if(index==s.length()){
13            if(validnum==1){
14                return sc;
15            }
16            return 0;
17        }
18        if(dp[index][tight][validnum][last2+1][last1+1][sc]!=null){
19            return dp[index][tight][validnum][last2+1][last1+1][sc];
20            
21        }
22        int dig=s.charAt(index)-'0';
23        int limit=tight==1?s.charAt(index)-'0':9;
24        long ans=0;
25        for(int d=0;d<=limit;d++){
26            int newtight=(tight==1 && d==dig)?1:0;
27            if(validnum==0 && d==0){
28                ans+=f(index+1,newtight,0,-1,-1,0,s);
29            }else if(validnum==0 && d>0){
30                ans+=f(index+1,newtight,1,-1,d,0,s);
31            }else if(last2==-1){
32                ans+=f(index+1,newtight,1,last1,d,sc,s);
33            }else{
34                int score=((last1>d && last1>last2) || (last1<d && last1<last2))?1:0;
35                ans+=f(index+1,newtight,1,last1,d,sc+score,s);
36            }
37        }
38        
39        
40        return dp[index][tight][validnum][last2+1][last1+1][sc]=ans;
41    }
42
43}