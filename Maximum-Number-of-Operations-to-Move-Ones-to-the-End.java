class Solution {
    public int maxOperations(String s) {
        int n=s.length();
        int one=0;
        int res=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                one++;
            }
            else if(i>0 && s.charAt(i)<s.charAt(i-1)){
                    res+=one;
            }
                
        }
        return res;
    }
}