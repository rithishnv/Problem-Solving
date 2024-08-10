class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        int i=s.length()-1,j=s.length()-1;
        while(i>-1){
            while(i>-1 && s.charAt(i--)!=' ');
            while(i>-1 && s.charAt(i)==' ')
            i--;
            for(int k=i+1;k<=j;k++){
                if(s.charAt(k)==' ')
                continue;
                sb.append(s.charAt(k));
            }
            j=i;
            sb.append(' ');
        }
        return sb.toString().trim();
    }
}