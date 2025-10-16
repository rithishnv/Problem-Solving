class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] arr=new int[value];
        int res=0;
        for(int i:nums){
            arr[((i%value)+value)%value]++;
        }
        while(arr[res%value]-->0)
        res++;
        return res;
    }
}