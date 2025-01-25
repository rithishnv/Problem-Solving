class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        List<int[]> li=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            li.add(new int[]{nums[i],i});
        }
        Collections.sort(li,(a,b)->a[0]-b[0]);
        int i=0;
        while(i<n){
            PriorityQueue<Integer> q=new PriorityQueue<>();
            int j=i;
            while(j<n && (i==j ||li.get(j)[0]-li.get(j-1)[0] <=limit)){
                q.add(li.get(j)[1]);
                j++;
            }
            while(i<j){
                nums[q.poll()]=li.get(i)[0];
                i++;
            }
        }
        return nums;
    }
}