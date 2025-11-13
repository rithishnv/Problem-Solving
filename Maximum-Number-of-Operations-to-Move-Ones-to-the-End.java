class Solution {
    public int maxOperations(String s) {
        int n=s.length();
        int one=0;
        int res=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                while(i<n && s.charAt(i)=='0'){
                    i++;
                }
                res+=one;
            }
            one++;
        }
        return res;
    }
}