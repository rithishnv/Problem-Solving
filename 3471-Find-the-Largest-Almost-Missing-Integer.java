class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] arr=new int[51];
        int n=nums.length;
        for(int i=0;i<n;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=i;j<i+k && i+k-1<n;j++){
                if(set.add(nums[j]))
                arr[nums[j]]++;
            }
        }
        for(int i=50;i>-1;i--){
            if(arr[i]==1)
            return i;
        }
        return -1;
    }
}