class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> li=new ArrayList<Integer>();
        Arrays.sort(nums);
        int c=nums[0];
        for(int i:nums){
            while(c<i){
                li.add(c);
                c++;
            }
            c++;
        }
        return li;
    }
}