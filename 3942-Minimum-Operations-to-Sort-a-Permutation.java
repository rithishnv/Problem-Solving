class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int x = nums[0];
        boolean asc = true, dsc = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (x + i) % n){
                asc = false;
            }
            if (nums[i] != (x - i + n) % n){
                dsc = false;
            }
        }
        if (!asc && !dsc){
            return -1;
        }
        if (asc && x == 0){
            return 0;
        }
        return Math.min(n - x, x + 2);
    }
}