class Solution {
    public long countGood(int[] nums, int k) {
        long res=0;
        Map<Integer,Integer> map=new HashMap<>();
        int l=0;
        long pair=0;
        for(int r=0;r<nums.length;r++){
                pair+=map.getOrDefault(nums[r],0);
                map.put(nums[r],map.getOrDefault(nums[r],0)+1);
                while(pair>=k){
                res+=nums.length-r;
                int lcnt=map.get(nums[l]);
                pair-=lcnt-1;
                map.put(nums[l],lcnt-1);
                l++;
                }
             }
        return res;
    }
}