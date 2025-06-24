class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> li=new ArrayList<>();
        int n=nums.length;
        boolean[] v=new boolean[n];
        for(int i=0;i<n;i++){
            if(nums[i]==key){
                int t=(i-k)<0?0:i-k;
                for(int j=t;j<n && j<=(i+k);j++){
                    if(!v[j]){
                    v[j]=true;
                    li.add(j);
                    }
                }
            }
        }
        return li;
    }
}