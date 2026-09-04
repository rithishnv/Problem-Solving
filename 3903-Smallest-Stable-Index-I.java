class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max=0,n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:nums){
            pq.add(i);
        }
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            if(max-pq.peek()<=k){
                return i;
            }
            pq.remove(nums[i]);
        }
        return -1;
    }
}