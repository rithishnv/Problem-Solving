class Solution {
    public String makeFancyString(String s) {
        if(s.length()<=2)
        return s;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length()-2;i++){
            if(s.charAt(i)==s.charAt(i+1)&&s.charAt(i)==s.charAt(i+2)){
                continue;
            }
            sb.append(s.charAt(i));
        }
        sb.append(s.charAt(s.length()-2));
        sb.append(s.charAt(s.length()-1));
        return sb.toString();
    }
}