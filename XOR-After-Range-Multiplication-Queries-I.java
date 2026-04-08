1class Solution {
2    public int xorAfterQueries(int[] nums, int[][] queries) {
3        int mod=(int)1e9+7;
4        for(int[] a:queries){
5            while(a[0]<=a[1]){
6                nums[a[0]]=(int)(((long)nums[a[0]]*a[3])%mod);
7                a[0]+=a[2];
8            }
9        }
10        int res=nums[0];
11        for(int i=1;i<nums.length;i++){
12            res^=nums[i];
13        }
14        return res;
15    }
16}