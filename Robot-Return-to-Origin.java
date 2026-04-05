1class Solution {
2    public boolean judgeCircle(String moves) {
3        int s=0,f=0;
4        for(char i:moves.toCharArray()){
5            if(i=='U')
6            s++;
7            else if(i=='L')
8            f++;
9            else if(i=='D')
10            s--;
11            else
12            f--;
13        }
14        return (s==0 && f==0);
15    }
16}