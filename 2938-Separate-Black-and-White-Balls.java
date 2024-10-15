class Solution {
    public long minimumSteps(String s) {
        long c=0,a=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
            c++;
            else{
                a+=c;
            }
        }
        return a;
    }
}