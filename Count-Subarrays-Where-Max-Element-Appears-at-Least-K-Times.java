class Solution {
    public long countSubarrays(int[] nums, int k) {
        long res=0;
        int j=0,cnt=0;
        int max=0;
        for(int i:nums)
        max=Math.max(max,i);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max){
            cnt++;
            }
            while(cnt>=k){
                if(nums[j]==max)
                cnt--;
            j++;
            }
            res+=j;
        }
        return res;
    }
}