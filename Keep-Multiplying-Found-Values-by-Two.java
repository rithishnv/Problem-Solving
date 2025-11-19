class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        while(Arrays.binarySearch(nums,original)>=0){
            original*=2;
        }
        return original;
    }
}