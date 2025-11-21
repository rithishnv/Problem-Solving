class Solution {
    public int countPalindromicSubsequence(String s) {
        int c=0;
            for(char i='a';i<='z';i++){
                int l=s.indexOf(i);
                int r=s.lastIndexOf(i);
                Set<Character> se=new HashSet<>();
                    for(int j=l+1;j<r;j++){
                        se.add(s.charAt(j));
                    }
                    c+=se.size();
                }
        return c;
    }
}