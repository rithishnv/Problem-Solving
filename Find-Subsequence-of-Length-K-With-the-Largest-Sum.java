class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        int[] res=new int[k];
        for(int i=0;i<nums.length;i++){
            List<Integer> li=map.getOrDefault(nums[i],new ArrayList<Integer>());
            li.add(i);
            map.put(nums[i],li);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        Arrays.sort(nums);
        for(int i=nums.length-1;i>nums.length-1-k;i--){
            List<Integer> li=map.get(nums[i]);
            pq.add(new int[]{li.get(0),nums[i]});
            li.remove(0);
            map.put(nums[i],li);
        }
        int i=0;
        while(!pq.isEmpty()){
            res[i++]=pq.poll()[1];
        }
        // System.out.println(map);
        return res;
    }
}