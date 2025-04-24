class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set=new HashSet<>();
        // Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            set.add(i);
            // map.put(map.getOrDefault(i,0)+1);
        }
        int c=set.size();
        int res=0;
        for(int i=0;i<nums.length;i++){
            set.clear();
            for(int j=i;j<nums.length;j++){
                set.add(nums[j]);
                if(set.size()==c)
                res++;
            }
        }
        return res;    
        }
}