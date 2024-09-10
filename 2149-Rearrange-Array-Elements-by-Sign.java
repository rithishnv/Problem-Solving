class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] n1=new int[nums.length];
        int i=0,j=1;
        for(int n:nums){
            if(n>0){
            n1[i]=n;
            i+=2;
            }
            else{
                n1[j]=n;
                j+=2;
            }
        }
        return n1;
    }
}