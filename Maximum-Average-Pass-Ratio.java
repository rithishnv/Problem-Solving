class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        double res=0;
        for(int[] arr:classes){
        pq.add(new double[]{(double)(arr[0]+1)/(arr[1]+1)-(double)arr[0]/arr[1],arr[0],arr[1]});
        }
        while(extraStudents-->0){
            double[] arr=pq.poll();
            arr[1]++;
            arr[2]++;
            pq.add(new double[]{(arr[1]+1)/(arr[2]+1)-(double)arr[1]/arr[2],arr[1],arr[2]});
        }
        while(pq.peek()!=null){
            res+=pq.peek()[1]/pq.peek()[2];
            pq.poll();
        }
        return res/classes.length;
    }
}