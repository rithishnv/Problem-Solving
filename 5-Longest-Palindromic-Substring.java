class Solution {
    public int pal(String s,int i,int j){
        while(i>-1 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
    public String longestPalindrome(String s) {
        int len=0,st=0,e=0;
        for(int i=0;i<s.length();i++){
            int l1=pal(s,i,i);
            int l2=pal(s,i,i+1);
            int max=Math.max(l1,l2);
            if(max>len){
                len=max;
                st=i-(max-1)/2;
                e=i+max/2;
            }
        }
        return s.substring(st,e+1);
    }
}