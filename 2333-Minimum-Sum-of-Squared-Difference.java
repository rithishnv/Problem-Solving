class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int k = k1 + k2;
        int mx = 0;
        int[] diff = new int[1000001];
        for(int i=0; i<n; i++) {
            int t = Math.abs(nums1[i] - nums2[i]);
            diff[t]++;
            mx = Math.max(mx,t);
        }

        long res = 0;
        for(int i=mx; i>0 && k>0; i--) {
            long m = Math.min(k, diff[i]);
            diff[i] -= m;
            diff[i-1] += m;
            k -= m;
        }
        for(int i=0; i<=(int) 1e5; i++) {
            if(diff[i] == 0){
                 continue;
            }
            res += (long) i * i * diff[i];
        }
        

        return res;
    }
}