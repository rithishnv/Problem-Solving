1class Solution {
2    public char processStr(String s,long k) {
3        long len=0;
4        for(char c:s.toCharArray()) {
5            if(Character.isLowerCase(c)) {
6                len++;
7            } 
8            else if(c=='*') {
9                if(len>0){
10                    len--;
11                }
12            }
13             else if(c=='#') {
14                len*=2;
15            }
16        }
17        if(k>=len){ 
18          return '.';
19        }
20
21        for(int i=s.length()-1;i>=0;i--) {
22            char c=s.charAt(i);
23            if(Character.isLowerCase(c)) {
24                if(k==len-1){ 
25                    return c;
26                }
27                len--;
28            } 
29            else if(c=='*') {
30                len++;
31            } 
32            else if(c=='#') {
33                len/=2;
34                k%=len;
35            }
36             else if(c=='%') {
37                k=len-1-k;
38            }
39        }
40
41        return '.';
42    }
43}