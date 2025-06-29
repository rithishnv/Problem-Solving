class Solution {
    public int numSubseq(int[] nums, int target) {
        int n=nums.length,l=0,r=n-1,res=0,mod=1000000007;
        Arrays.sort(nums);
        int[] arr=new int[n];
        arr[0]=1;
        for(int i=1;i<n;++i)
            arr[i]=arr[i-1]*2%mod;
            while(l<=r){
                if(nums[l]+nums[r]>target)
                r--;
                else
                res=(res+arr[r-l++])%mod;
            }
        return res;
    }
}