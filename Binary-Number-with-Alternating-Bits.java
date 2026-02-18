1class Solution {
2    public boolean hasAlternatingBits(int n) {
3        boolean one=false,zero=false;
4        if(n%2==0)
5        zero=true;
6        else
7        one=true;
8        while(n>0){
9            if(n%2==0 && zero){
10                one=true;
11                zero=false;
12            }
13            else if(n%2==1 && one){
14                one=false;
15                zero=true;
16            }
17            else{
18                return false;
19            }
20            n/=2;
21        }
22        return true;
23    }
24}