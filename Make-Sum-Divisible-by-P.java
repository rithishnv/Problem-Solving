1class Solution {
2    public int minSubarray(int[] nums, int p) {
3        int sum=0;
4        for(int i:nums)
5        sum=(sum+i)%p;
6        int r=sum%p;
7        int res=nums.length;
8        if(r==0)
9        return 0;
10        Map<Integer,Integer> map=new HashMap<>();
11        map.put(0,-1);
12        int csum=0;
13        for(int i=0;i<nums.length;i++){
14            csum=(csum+nums[i])%p;
15            int prefix=(csum-r+p)%p;
16            if(map.containsKey(prefix))
17            res=Math.min(res,i-map.get(prefix));
18            map.put(csum,i);
19        }
20        return (res==nums.length)?-1:res;
21    }
22}