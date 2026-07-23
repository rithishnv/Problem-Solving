class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return n;
        }
        int bit = 0;
        while(n != 0){
           n = n >> 1;
           bit++;
        }
        return (int)Math.pow(2,bit  );
    }
}