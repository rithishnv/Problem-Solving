class Solution {
    public boolean checkDivisibility(int n) {
        int p=1;
        int s=0;
        int t=n;
        while(n>0){
            p*=n%10;
            s+=n%10;
            n/=10;
        }
        s+=p;
        return t%s==0;
    }
}