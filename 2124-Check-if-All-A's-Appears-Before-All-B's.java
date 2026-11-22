class Solution {
    public boolean checkString(String s) {
        int i=s.indexOf('b');
        if(i==-1){
            return true;
        }
        int n=s.length();
        for(int j=i+1;j<n;j++){
            if(s.charAt(j)=='a')
            return false;
        }
        return true;
    }
}