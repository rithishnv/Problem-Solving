class Solution {
    public String compressedString(String word) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<word.length()){
            int j=0;
            char c=word.charAt(i);
            while(i<word.length() && word.charAt(i)==c && j<9){
                j++;
                i++;
            }
            sb.append(j);
            sb.append(c);
        }
        return sb.toString();
    }
}