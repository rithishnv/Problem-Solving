class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long res=0;
        int cnt=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i:nums){
            cnt=(cnt+(i%modulo==k?1:0))%modulo;
            res+=map.getOrDefault((cnt-k+modulo)%modulo,0);
            map.put(cnt,map.getOrDefault(cnt,0)+1);
        }
        return res;
    }
}