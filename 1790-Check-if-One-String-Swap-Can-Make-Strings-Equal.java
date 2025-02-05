class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int cnt=0;
        int[] a=new int[2];
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(cnt==2)
                return false;
                a[cnt++]=i;
            }
        }
        return (s1.charAt(a[0])==s2.charAt(a[1]) && s2.charAt(a[0])==s1.charAt(a[1]));
    }
}