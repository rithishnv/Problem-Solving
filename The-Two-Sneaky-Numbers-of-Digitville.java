class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int m=-1,j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>m)m=nums[i];

        }
        int []n=new int[m+1];
        int []h=new int[2];
        for(int i=0;i<nums.length;i++){
            n[nums[i]]++;
            if(n[nums[i]]==2){h[j++]=nums[i];}

            }
        return h;
    }
}