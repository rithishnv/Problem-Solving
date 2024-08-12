class KthLargest {
    private PriorityQueue<Integer> li;
    private int a;
    public KthLargest(int k, int[] nums) {
        li=new PriorityQueue<>();
        a=k;
        for(int i:nums)
        add(i);
    }
    
    public int add(int val) {
        if(li.size()<a){
        li.offer(val);
        }
        else if(val>li.peek()){
            li.poll();
            li.offer(val);
        }
        return li.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */