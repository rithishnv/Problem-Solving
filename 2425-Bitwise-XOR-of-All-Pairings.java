class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
      int n1=nums1.length,n2=nums2.length,r=0;
      if(n1%2!=0){
        for(int i=0;i<n2;i++)
        r^=nums2[i];
      }
      if(n2%2!=0){
        for(int i=0;i<n1;i++)
        r^=nums1[i];
      }
        return r;
    }
}