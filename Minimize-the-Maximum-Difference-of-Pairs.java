class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n=nums.length;
        int l=0,r=nums[n-1]-nums[0];
        while(l<r){
            int mid=(r+l)/2;
            int pair=0;
            for(int i=1;i<n;i++){
                if(nums[i]-nums[i-1]<=mid){
                    pair++;
                    i++;
                }
            }
            if(pair>=p)
            r=mid;
            else
            l=mid+1;
        }
        return l;
    }
}