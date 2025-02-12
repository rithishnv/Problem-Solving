class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int j=0,k=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]==x)
            nums[j++]=i;
        }
        for(int i:queries){
            if(j<i)
            queries[k++]=-1;
            else
            queries[k++]=nums[i-1];
        }
        return queries;
    }
}