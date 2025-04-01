class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int res=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target){
                    return sum;
                }
                int y=Math.abs(target-sum);
                if(y<min){
                min=y;
                res=sum;
                }
                if(sum>target){
                k--;
                }
                else
                j++;
            }
        }
        return res;
    }
}