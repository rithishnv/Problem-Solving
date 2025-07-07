class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->(a[0]-b[0]));
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int res=0,i=0,n=events.length;
        for(int e=1;e<=100000;e++){
            while(!pq.isEmpty() && pq.peek()<e){
                pq.poll();
            }
            while(i<n && events[i][0]==e){
                pq.add(events[i++][1]);
            }
            if(!pq.isEmpty()){
                pq.poll();
                res++;
            }
        }
        return res;
    }
}