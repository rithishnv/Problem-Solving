class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;
        int max=0;
        long tot=0;
        for(int i:candies){
            max=Math.max(i,max);
            tot+=i;
        }
        if(tot<k)
        return 0;
        int l=1,r=max,ans=0;
        while(l<=r){
            int m=l+(r-l)/2;
            if(isValid(candies,m,k)){
                ans=m;
                l=m+1;
            }
            else
                r=m-1;
        }
        return ans;
    }
    boolean isValid(int[] candies,int m,long k){
        long c=0;
            for(int i:candies){
                c+=i/m;
            }
            return c>=k;
    }
}