1class Solution {
2    public String processStr(String s) {
3        StringBuilder sb=new StringBuilder();
4        for(char i:s.toCharArray()){
5            if(i=='*'){
6                if(sb.length()!=0){
7                    sb.deleteCharAt(sb.length()-1);
8                }
9            }
10            else if(i=='#'){
11                sb.append(sb);
12            }
13            else if(i=='%'){
14                sb.reverse();
15            }
16            else{
17                sb.append(i);
18            }
19        }
20        return sb.toString();
21    }
22}