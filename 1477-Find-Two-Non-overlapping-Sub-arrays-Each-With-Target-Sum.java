class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int sum=0;
        int i=0,j=0;
        int n=arr.length;
        int[] min=new int[n];
        Arrays.fill(min,Integer.MAX_VALUE);
        int ans=Integer.MAX_VALUE;
        int res=Integer.MAX_VALUE;
        while(j<n){
            sum+=arr[j];
            while(sum>target){
                sum-=arr[i];
                i++;
            }
            if(sum==target){
                int len=j-i+1;
                if(i>0 && min[i-1]!=Integer.MAX_VALUE){
                    ans=Math.min(ans,len+min[i-1]);
                }
                res=Math.min(res,len);
            }
            min[j]=res;
            j++;
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}