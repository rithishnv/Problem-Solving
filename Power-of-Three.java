class Solution {
    public boolean isPowerOfThree(int n) {
        while(n>2){
            if(n%3==0)
            n=n/3;
            else
            return false;
        }
        return n==1;
    }
}