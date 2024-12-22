class Solution {
    public String stringHash(String s, int k) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            int j=0;
            int st=0;
            while(i<s.length()&&j<k){
                st+=Integer.valueOf(s.charAt(i))-'a';
                i++;
                j++;
            }
            st=st%26;
            sb.append((char)('a'+st));
            i--;
        }
        return sb.toString();
    }
}