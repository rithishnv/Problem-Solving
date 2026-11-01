class Solution {
    public int minMoves(int[] nums) {
        int sum=0;
        int min=Integer.MAX_VALUE;
        for (int x:nums) {
            sum+=x;
            min=Math.min(min,x);
        }
        return sum-(nums.length*min);
    }
}