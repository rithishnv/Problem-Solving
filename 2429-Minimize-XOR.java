class Solution {
    public int minimizeXor(int num1, int num2) {
        int n=Integer.bitCount(num2);
        int r=0,c=0;
        for(int i=31;i>-1;i--){
            if((num1&(1<<i))!=0 && c<n){
                r|=1<<i;
                c++;
            }
        }
        for(int i=0;i<32 && c<n;i++){
            if((r&(1<<i))==0){
                r|=1<<i;
                c++;
            }
        }
        return r;
    }
}