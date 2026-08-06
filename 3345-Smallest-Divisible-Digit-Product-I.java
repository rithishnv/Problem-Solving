class Solution {
    public int smallestNumber(int n, int t) {
        while(n<10){
            if(n%t==0)
            return n;
            n++;
        }
        while(n<=100){
            if(((n%10)*(n/10))%t==0){
                return n;
            }
            n++;
        }
        return n;
    }
}