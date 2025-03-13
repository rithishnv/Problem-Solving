class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int[] arr=new int[n+1];
        int j=0,sum=0;
        for(int i=0;i<n;i++){
            while(sum+arr[i]<nums[i]){
                if(j==queries.length)
                return -1;
                int s=queries[j][0];
                int e=queries[j][1];
                int v=queries[j][2];
                j++;
                if(e<i)
                continue;
                arr[Math.max(i,s)]+=v;
                arr[e+1]-=v;
            }
            sum+=arr[i];
        }
        return j;
    }
}