class Solution {
    public boolean divideArray(int[] nums) {
        int[] arr=new int[501];
        for(int i:nums){
            arr[i]++;
        }
        int n=nums.length/2;
        for(int i:nums){
            if(arr[i]%2!=0)
                return false;        
        }
        return true;
    }
}