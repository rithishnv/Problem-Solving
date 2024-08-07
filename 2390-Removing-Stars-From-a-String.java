class Solution {
    public String removeStars(String s) {
        StringBuilder sb=new StringBuilder();
        for(char i:s.toCharArray()){
            if(i=='*'){
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                sb.append(i);
            }
        }
        return sb.toString();
    }
}