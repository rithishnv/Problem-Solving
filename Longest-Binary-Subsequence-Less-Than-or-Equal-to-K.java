class Solution {
    public int longestSubsequence(String s, int k) {
        int res=0,cnt=1;
        for(int i=s.length()-1;i>-1;i--){
            if(s.charAt(i)=='0' || cnt<=k){
                k-=cnt*(s.charAt(i)-'0');
                res++;
            }
            if(cnt<=k)
            cnt*=2;
        }
        return res;
    }
}