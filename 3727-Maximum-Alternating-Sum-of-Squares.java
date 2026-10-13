class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        int i=0,j=n-1;
        for(i=0;i<n;i++){
            if(nums[i]<0){
                nums[i]*=-1;
            }
        }
        long res=0;
        i=0;
        Arrays.sort(nums);
        while(i<j){
            res+=((nums[j]*nums[j])-(nums[i]*nums[i]));
            i++;
            j--;
        }
        if(n%2!=0){
            res+=(nums[j]*nums[j]);
        }
        return res;
    }
}