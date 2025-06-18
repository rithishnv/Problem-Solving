class Solution {
    public int[][] divideArray(int[] nums, int k) {
       Arrays.sort(nums);
       int n=nums.length;
       int[][] arr=new int[n/3][3];
       int j=0;
       for(int i=0;i<nums.length;i+=3){
        if(i+2<n && nums[i+2]-nums[i]<=k){
            arr[j++]=new int[]{nums[i],nums[i+1],nums[i+2]};
        }
        else
            return new int[0][0];
       } 
       return arr;
    }
}