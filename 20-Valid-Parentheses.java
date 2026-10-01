class Solution {
    public boolean isValid(String s) {
        Stack<Character> s1=new Stack();
        int c=0,p=0;
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)==('(')||s.charAt(i)==('[')||s.charAt(i)==('{')) {
            s1.push(s.charAt(i));
            continue;
           }
           if(s1.empty())
           return false;
           if(s.charAt(i)==(')')||s.charAt(i)==(']')||s.charAt(i)==('}'))
            c++;     
        if(s.charAt(i)==(')')&&s1.peek()=='('||s.charAt(i)==(']')&&s1.peek()=='['||s.charAt(i)==('}')&&s1.peek()=='{'){
                s1.pop();
                p++;
            }
        }
        return s1.empty()&&c==p;
    }
}