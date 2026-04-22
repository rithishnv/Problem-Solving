1class Solution {
2    public List<String> twoEditWords(String[] queries, String[] dictionary) {
3        List<String> li=new ArrayList<>();
4        for(String s:queries){
5            for(String a:dictionary){
6                if(s.equals(a)){
7                    li.add(s);
8                    break;
9                }
10                else{
11                    int cnt=0;
12                    for(int i=0;i<s.length();i++){
13                        if(s.charAt(i)!=a.charAt(i))
14                        cnt++;
15                        if(cnt>2)
16                        break;
17                    }
18                    if(cnt<=2){
19                        li.add(s);
20                        break;
21                    }
22                }
23            }
24        }
25        return li;
26    }
27}