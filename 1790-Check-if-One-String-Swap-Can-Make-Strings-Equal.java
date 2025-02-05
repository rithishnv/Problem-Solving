class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] a=new int[26];
        for(char i:s1.toCharArray())
        a[i-'a']++;
        for(char i:s2.toCharArray()){
            if(--a[i-'a']<0)
            return false;
        }
        int cnt=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(++cnt>2)
                return false;
            }
        }
        return true;
    }
}