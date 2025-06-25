class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left=-10000000000L;
        long right=10000000000L;
        while(left<right){
            long mid=left+(right-left)/2;
            if(count(nums1,nums2,mid)<k)
            left=mid+1;
            else
            right=mid;
        }
        return left;
    }
    public long count(int[] nums1,int[] nums2,long t){
        long res=0;
        for(int n:nums1){
            if(n==0){
                if(t>=0)
                res+=nums2.length;
                continue;
            }
            int l=0,r=nums2.length;
            while(l<r){
                int m=l+(r-l)/2;
                long p=(long) n*nums2[m];
                if(p<=t){
                    if(n>0)
                    l=m+1;
                    else
                    r=m;
                }
                else{
                    if(n>0)
                    r=m;
                    else
                    l=m+1;
                }
            }
            res+=(n>0)?l:nums2.length-l;
        }
        return res;
    }
}