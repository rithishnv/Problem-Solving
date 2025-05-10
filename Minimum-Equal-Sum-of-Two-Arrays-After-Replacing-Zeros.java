class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long c1=0,c2=0,s1=0,s2=0;
        for(int i:nums1){
            if(i==0){
            s1+=1;
            c1++;
            }
            s1+=i;
        }
        for(int i:nums2){
            if(i==0){
            s2+=1;
            c2++;
            }
            s2+=i;
        }
        if((s1<s2 && c1==0) || (s2<s1 && c2==0))
        return -1;
        return Math.max(s1,s2);
    }
}