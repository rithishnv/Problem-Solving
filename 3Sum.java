class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> li=new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                List<Integer> l=  new ArrayList<Integer>();
                l.add(nums[i]);
                l.add(nums[j]);
                l.add(nums[k]);
                if(set.add(l))
                    li.add(l);
                }
                if(sum>0){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return li;
    }
}