class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer,Long> map=new HashMap<>();
        long r=(long)nums.length*(nums.length-1)/2;
        long c=0;
        for(int i=0;i<nums.length;i++){
            int t=nums[i]-i;
            if(map.containsKey(t)){
                c+=map.get(t);
            }
            map.put(t,map.getOrDefault(t,0l)+1);
        }
        return r-c;
    }
}