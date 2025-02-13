class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i:nums){
            pq.add((long)i);
        }
        int c=0;
        while(pq.peek()<k){
            long r=(pq.poll())*2 + pq.poll();
            pq.add(r);
            c++;
        }
        return c;
    }
}