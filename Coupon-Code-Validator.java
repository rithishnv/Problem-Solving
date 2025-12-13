1class Solution {
2    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
3    List<String> li=new ArrayList<>();
4       li.addAll(add(code,businessLine,isActive,"electronics"));
5       li.addAll(add(code,businessLine,isActive,"grocery"));
6       li.addAll(add(code,businessLine,isActive,"pharmacy"));
7       li.addAll(add(code,businessLine,isActive,"restaurant"));
8    return li;
9    }
10    public List<String> add(String[] code, String[] businessLine, boolean[] isActive,
11    String x){
12        List<String> l=new ArrayList<>();
13        int n=code.length;
14            for(int i=0;i<n;i++){
15            if(isActive[i]){
16            if(businessLine[i].equals(x)){
17                if(code[i].length()>0 && check(code[i])){
18                    l.add(code[i]);
19                }
20                }
21            }
22        }
23        Collections.sort(l);
24        return l;
25    }
26    public boolean check(String a){
27        for(char i:a.toCharArray()){
28            if(!((i>='a' && i<='z') || (i>='A' && i<='Z') ||(i>='0' && i<='9') 
29            || (i=='_')))
30            return false;
31        }
32        return true;
33    }
34}