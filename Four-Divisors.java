1class Solution {
2    public int sumFourDivisors(int[] nums) {
3        int res=0;
4        int c,t;
5        for(int i:nums){
6            c=0;
7            t=0;
8            for(int j=1;j<=Math.sqrt(i);j++){
9                if(i%j==0){
10                    if(j*j==i){
11                    c++;
12                    t+=j;
13                    }
14                    else{
15                        c+=2;
16                        t+=(j+(i/j));
17                    }
18                    if(c>4)
19                    break;
20                }
21            }
22            if(c==4)
23            res+=t;
24        }
25        return res;
26    }
27}