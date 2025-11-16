class Solution {
    public int numSub(String s) {
        long c=0;
        long res=0;
        for(char i:s.toCharArray()){
            if(i=='1'){
                c++;
            }
            else{
                res+=c*(c+1)/2;
                c=0;
            }
        }
        res+=c*(c+1)/2;
        return (int)(res%1000000007);
    }
}