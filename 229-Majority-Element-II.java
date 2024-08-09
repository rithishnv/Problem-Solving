class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        List<Integer> li=new ArrayList<>();
        int n=nums.length/3;
        for(int i=0;i<nums.length-1;i++){
            int c=1;
            while(i<nums.length-1&& nums[i]==nums[i+1]){
                if(++c>n){
                    if(!li.contains(nums[i]))
                    li.add(nums[i]);
                 break;
                } 
                i++;  
            }
            if(i<nums.length-1 && nums[i]!=nums[i+1] && 1>n && !li.contains(nums[i])){
                li.add(nums[i]);
            }
        }
        if(!li.contains(nums[nums.length-1]) && 1>n){
                li.add(nums[nums.length-1]);
            }
        return li;
    }
}