class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        List<List<Integer>> li=new ArrayList<>();
        for(int i=0;i<26;i++){
            li.add(new ArrayList<Integer>());
        }
        for(int i=0;i<s1.length();i++){
            int a=s1.charAt(i)-'a';
            int b=s2.charAt(i)-'a';
            li.get(a).add(b);
            li.get(b).add(a);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            int n=baseStr.charAt(i)-'a';
            int min=check(li,n,new boolean[26]);
            sb.append((char)('a'+min));
        }
        return sb.toString();
    }
    public int check(List<List<Integer>> li,int n,boolean[] v){
        v[n]=true;
        int min=n;
        for(int i:li.get(n)){
            if(!v[i]){
            int t=check(li,i,v);
            min=Math.min(t,min);
            }
        }
      return min;
    }
}