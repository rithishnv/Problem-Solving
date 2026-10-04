class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        int t=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='*'){
                t++;
            }
            else{
                t--;
            }
            if(t<0){
                return false;
            }
        }
        t=0;
        for(int i=n-1;i>-1;i--){
            if(s.charAt(i)==')' || s.charAt(i)=='*'){
                t++;
            }
            else{
                t--;
            }
            if(t<0){
                return false;
            }
        }
        return true;
    }
}