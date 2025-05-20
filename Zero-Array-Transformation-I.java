class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] arr=new int[nums.length+1];
        for(int[] i:queries){
                arr[i[0]]++;
                arr[i[1]+1]--;
        }
        for(int i=1;i<arr.length;i++){
            arr[i]+=arr[i-1];
        }
        for(int i=0;i<nums.length;i++){
            if(arr[i]<nums[i])
            return false;
        }
        return true;
    }
}