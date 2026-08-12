class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        int i=0,j=0;
        int n=nums.length;
        while(i<n && j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.get(nums[j])>k){
                map.put(nums[i],map.getOrDefault(nums[i],0)-1);
                i++;
            }
            res=Math.max(res,j-i+1);
            j++;
        }
        return res;
    }
}