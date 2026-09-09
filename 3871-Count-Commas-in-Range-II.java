class Solution {
    public long countCommas(long n) {
        if(n<1000){
            return 0;
        }
        long c=0;
        long t=999;
        while(t<n){
            c+=(n-t);
            t=(t*1000)+999;
        }
        return c;
    }
}