class Solution {
    public int makeTheIntegerZero(long num1, long num2) {
        for(int i=1;i<61;i++){
            int cnt=Long.bitCount(num1-i*num2);
            if(cnt<=i && i<=num1-i*num2){
                return i;
            }
        }
        return -1;
    }
}