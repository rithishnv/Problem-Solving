class Solution {
    public long sumAndMultiply(int n) {
        long res=0;
        while(n>0){
            if(n%10!=0){
                res=res*10+(n%10);
            }
            n/=10;
        }
        long n1=0;
        while(res>0){
            n1=n1*10+(res%10);
            n+=res%10;
            res/=10;
        }
        return n1*n;
    }
}