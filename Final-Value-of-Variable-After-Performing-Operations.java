class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int i=0;
        for(String j:operations)
        i=(j.charAt(1)=='+')?i+1:i-1;
        return i;
    }
}