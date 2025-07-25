class Solution {
    public int maxSum(int[] nums) {
        boolean[] v=new boolean[101];
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int cnt=0,s=0;
        for(int i:nums){
            max=Math.max(max,i);
            if(i>0 && !v[i]){
                v[i]=true;
                s+=i;
                cnt++;
            }
        }
        return (cnt==0)?max:s;
    }
}