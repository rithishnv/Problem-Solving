class Solution {
    public int minPartitions(String n) {
        int r=0;
        for(char i:n.toCharArray()){
            r=Math.max(r,i-'0');
        }
        return r;
    }
}