class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb=new StringBuilder(s);
        int n=sb.indexOf(part);
        while(n!=-1){
            sb.delete(n,part.length()+n);
            n=sb.indexOf(part);
        }
        return sb.toString();
    }
}