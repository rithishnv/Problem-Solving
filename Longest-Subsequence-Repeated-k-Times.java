class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        String res="";
        Queue<String> q=new LinkedList<>();
        q.add("");
        while(!q.isEmpty()){
            String t=q.poll();
            for(char i='a';i<='z';i++){
                String a=t+i;
                if(check(a,s,k)){
                    res=a;
                    q.add(a);
                }
            }
        }
        return res;
    }
    public boolean check(String s,String t,int k){
        int tot=0,len=0;
        for(char i:t.toCharArray()){
            if(i==s.charAt(len)){
                if(++len==s.length()){
                    len=0;
                    if(++tot==k)
                    return true;
                }
            }
        }
        return false;
    }
}