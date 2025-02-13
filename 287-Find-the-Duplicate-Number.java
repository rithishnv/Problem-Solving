class Solution {
    public int findDuplicate(int[] nums) {
        int[] arr=new int[nums.length+1];
        for(int i:nums){
            if(++arr[i]>1)
            return i;
        }
        return -1;
    }
}