1class Solution {
2    public int maxNumberOfBalloons(String text) {
3        int a=0,b=0,l=0,o=0,n=0;
4        for(char i:text.toCharArray()){
5            if(i=='a')
6            a++;
7            else if(i=='b')
8            b++;
9            else if(i=='l')
10            l++;
11            else if(i=='o')
12            o++;
13            else if(i=='n')
14            n++;
15        }
16        l/=2;
17        o/=2;
18        return Math.min(a,(Math.min(b,Math.min(l,Math.min(o,n)))));
19    }
20}