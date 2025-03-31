class Solution {
    public long putMarbles(int[] weights, int k) {
        PriorityQueue<Integer> min=new PriorityQueue<>();
        PriorityQueue<Integer> max=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<weights.length-1;i++){
            min.add(weights[i]+weights[i+1]);
            max.add(weights[i]+weights[i+1]);
        }
        long sum=0;
        for(int i=0;i<k-1;i++){
            sum+=max.poll()-min.poll();
        }
        return sum;
    }
}