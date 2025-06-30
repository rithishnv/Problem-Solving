class Solution {
    public int findLHS(int[] nums) {
       Arrays.sort(nums);
       int res=0;
        for(int i=0;i<nums.length;i++){
            int t=-1;
       for(int j=0;j<nums.length;j++){
            if(nums[j]-nums[i]==1){
                t=j;
            }
            else if(nums[j]-nums[i]>1)
            break;
       }
       if(t!=-1 && t-i+1>res)
            res=t-i+1;
        }

        return res;
    }
}