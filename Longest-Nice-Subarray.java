class Solution {
    public int longestNiceSubarray(int[] nums) {
     int l=0,v=0;
     int n=nums.length;
     int len=0;
     for(int r=0;r<n;r++){
        while((v&nums[r])!=0){
            v^=nums[l];
            l++;
        }
        v|=nums[r];
        len=Math.max(len,r-l+1);
     }   
     return len;
    }
}