class Solution {
    public String finalString(String s) {
        StringBuilder sb=new StringBuilder();
        for(char i:s.toCharArray()){
        if(i=='i')
        sb.reverse();
        else
        sb.append(i);
        }
        return sb.toString();
    }
}