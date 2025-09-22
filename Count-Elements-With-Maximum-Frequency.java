class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] arr=new int[101];
        int cnt=0,max=0;
        for(int i:nums){
            arr[i]++;
            max=Math.max(arr[i],max);
        }
        for(int i:arr){
            if(i==max){
                cnt++;
            }
        }
        return cnt*max;
    }
}