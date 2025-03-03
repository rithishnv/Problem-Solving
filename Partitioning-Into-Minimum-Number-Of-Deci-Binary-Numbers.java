class Solution {
    public int minPartitions(String n) {
        char r='0';
        for(char i:n.toCharArray()){
            if(i>r)
            r=i;
        }
        return r-'0';
    }
}