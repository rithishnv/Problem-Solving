class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int q=queries.length;
        boolean[] res=new boolean[q];
        int len=nums.length;
        int[] component=new int[len];
            component[0]=0;
        for(int i=1;i<len;i++){
           if(nums[i]-nums[i-1]<=maxDiff){
            component[i]=component[i-1];
           }else{
            component[i]=component[i-1]+1;
           }
        }

        for(int i=0;i<q;i++){
            int x=queries[i][0];
            int y=queries[i][1];
            if(component[x]==component[y]){
                res[i]=true;
            }
        }
        return res;
    }
}