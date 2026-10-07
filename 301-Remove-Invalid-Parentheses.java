class Solution {
    HashSet<String>set=new HashSet<>();
    int maxLen=-1;
    public List<String> removeInvalidParentheses(String s) {
        set.clear();
        maxLen=-1;
        solve(0,new StringBuilder(),s);
        return new ArrayList<>(set);
    }
    public void solve(int idx,StringBuilder curr,String s){
        if(idx==s.length()){
            if(isValid(curr.toString())){
                int len=curr.length();
                if(len>maxLen){
                    set.clear();
                    maxLen=len;
                    set.add(curr.toString());
                }
                else if(len==maxLen){
                    set.add(curr.toString());
                }
            }
            return ;
        }
        char ch=s.charAt(idx);
        if(ch=='('||ch==')'){
            solve(idx+1,curr,s);
        }
        curr.append(ch);
        solve(idx+1,curr,s);
        curr.deleteCharAt(curr.length()-1);
    }
    public boolean isValid(String s){
        int ans=0;
       for(char ch:s.toCharArray()){
        if(ch=='('){
            ans++;
        }
        else if(ch==')'){
            ans--;
            if(ans<0){
                return false;
            }
        }
       }
       return ans==0;
    }
}