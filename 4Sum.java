class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> li=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-3;i++){
            if(i!=0 && nums[i]==nums[i-1])
            continue;
            for(int j=i+1;j<n-2;j++){
                if(j!=i+1 && nums[j]==nums[j-1])
                continue;
                int k=n-1;
                int l=j+1;
                while(l<k){
                    long sum=(long)nums[i]+nums[j]+nums[l]+nums[k];
                    if(sum==target){
                        li.add(Arrays.asList(nums[i],nums[j],nums[l],nums[k]));
                        while(l<k && nums[l]==nums[l+1]) l++;
                        l++;
                        k--;
                    }
                    else if(sum>target)
                    k--;
                    else
                    l++;
                }
            }
        }
        return li;
    }
}