1class Solution {
2    public String addBinary(String a, String b) {
3        StringBuilder sb=new StringBuilder();
4        int r=0;
5        int n1=a.length()-1,n2=b.length()-1;
6        while(n1>-1 && n2>-1){
7            int t=a.charAt(n1--)-'0'+b.charAt(n2--)-'0';
8            t+=r;
9            r=(t>1)?1:0;
10            sb.append(t%2);
11        }
12        while(n1>-1){
13            int t=a.charAt(n1--)-'0';
14            t+=r;
15            r=(t>1)?1:0;
16            sb.append(t%2);
17        }
18        while(n2>-1){
19            int t=b.charAt(n2--)-'0';
20            t+=r;
21            r=(t>1)?1:0;
22            sb.append(t%2);
23        }
24        if(r!=0)
25        sb.append(1);
26        return sb.reverse().toString();
27    }
28}