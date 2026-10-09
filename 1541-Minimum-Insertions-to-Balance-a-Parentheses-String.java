class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        int t=0;
        int o=0,c=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                o+=2;
                if(o%2==1){
                    t++;
                    o--;
                }
            }
            else{
                o--;
                if(o<0){
                    t++;
                    o=1;
                }
            }
        }
        return t+o;
    }
}