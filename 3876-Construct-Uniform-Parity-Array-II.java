class Solution {
    public boolean uniformArray(int[] nums1) {
        int e=Integer.MAX_VALUE,o=Integer.MAX_VALUE;
        for(int i:nums1){
            if(i%2==0){
                e=Math.min(e,i);
            }
            else{
                o=Math.min(o,i);
            }
        }
        if(e!=Integer.MAX_VALUE && o!=Integer.MAX_VALUE && e-o<1){
            return false;
        }
        return true;
    }
}