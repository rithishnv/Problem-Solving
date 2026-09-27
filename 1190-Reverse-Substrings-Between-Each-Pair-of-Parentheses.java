class Solution {
    public String reverseParentheses(String s) {
        char[] a=s.toCharArray();
        Stack<Character> s1=new Stack<>();
        List<Character> li=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(a[i]==')'){
            while(s1.peek()!='('){
                li.add(s1.pop());
            }
            s1.pop();
            while(li.size()>0){
                s1.push(li.remove(0));
            }
            }
            else
            s1.push(a[i]);
    }
    StringBuilder sb=new StringBuilder();
    while(!s1.isEmpty()){
        sb.append(s1.pop());
    }
    sb.reverse();
    return sb.toString();
}
}