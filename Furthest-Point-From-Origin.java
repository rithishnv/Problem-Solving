1class Solution {
2    public int furthestDistanceFromOrigin(String moves) {
3        int res=0;
4        int r=0;
5        for(char i:moves.toCharArray()){
6            if(i=='R'){
7                res++;
8            }
9            else if(i=='L'){
10                res--;
11            }
12            else{
13                r++;
14            }
15        }
16        if(res<0)
17        res*=-1;
18        return r+res;
19    }
20}