class Solution {
    public long coloredCells(int n) {
        long s=1;
        for(int i=1;i<n;i++){
            s+=4*i;
        }
        return s;
    }
}