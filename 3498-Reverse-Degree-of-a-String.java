class Solution {
    public int reverseDegree(String s) {
        int res=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            res+=('z'-s.charAt(i)+1)*(i+1);
        }
        return res;
    }
}