class Solution {
    public int longestSubarray(int[] nums) {
      int max=0,maxl=0,c=0;
      for(int i:nums){
        max=Math.max(i,max);
      }
      for(int i:nums){
        if(i==max){
            c++;
            maxl=Math.max(c,maxl);
        }
        else{
            c=0;
        }
      }
        return  maxl;
    }
}