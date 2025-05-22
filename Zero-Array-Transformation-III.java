class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        Arrays.sort(queries,(a,b)->a[0]-b[0]);
        int n=nums.length;
        int[] arr=new int[n+1];
        int cur=0;
        for(int i=0,j=0;i<n;i++){
            cur+=arr[i];
            while(j<queries.length && queries[j][0]<=i){
                pq.add(queries[j++][1]);
            }
            while(cur<nums[i] && pq.size()>0 && pq.peek()>=i){
                cur++;
                arr[pq.poll()+1]--;
            }
            if(cur<nums[i])
            return -1;
        }
        return pq.size();
    }
}