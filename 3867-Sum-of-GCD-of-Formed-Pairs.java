class Solution {
    public long gcdSum(int[] nums) {
        int max=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            max=Math.max(nums[i],max);
            nums[i]=gcd(nums[i],max);
        }
        Arrays.sort(nums);
        int i=0,j=n-1;
        long res=0;
        while(i<j){
            res+=gcd(nums[i++],nums[j--]);
        }
        return res;
    }
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}