class Solution {
    public int smallestNumber(int n) {
        int j=1;
        while(j<n){
            j=j<<1;
            j|=1;
        }
        return j;
    }
}