1class Solution {
2    ArrayList<String> li=new ArrayList<>();
3    void check(int ind,char[] arr,int n,String s,int k){
4        if(li.size()==n)
5        return ;
6        if(s.length()==k){
7        li.add(new String(s));
8        return;
9        }
10        for(int i=0;i<3;i++){
11            StringBuilder sb=new StringBuilder(s);
12            if(sb.length()!=0 && sb.charAt(sb.length()-1)==arr[i])
13            continue;
14            sb.append((char)(i+'a'));
15            check(ind,arr,n ,sb.toString(),k);
16            sb.deleteCharAt(sb.length()-1);
17        }
18    }
19    public String getHappyString(int n, int k) {
20        check(0,new char[]{'a','b','c'},k,"",n);
21        return (li.size()==k)?li.get(k-1):"";
22    }
23}