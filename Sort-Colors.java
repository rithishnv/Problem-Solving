class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int z=0,o=0;
        for(int i:nums){
            if(i==0)
            z++;
            else if(i==1)
            o++;
        }
        int j=0;
        for(int i=0;i<z;i++)
        nums[j++]=0;
        for(int i=0;i<o;i++)
        nums[j++]=1;
        for(int i=z+o;i<n;i++)
        nums[j++]=2;
        return ;
        
    }
}