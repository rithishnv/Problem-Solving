1class Solution {
2    public int countOdds(int low, int high) {
3        // int res=0;
4        // if(high%2!=0)
5        // res++;
6        // high/=2;
7        // low/=2;
8        // if(low%2!=0)
9        // res++;
10        // if(high%2!=0)
11        // res++;
12        // res+=(high-low)/2;
13        return (high/2)-(low/2)+((high%2!=0)?1:0);
14    }
15}