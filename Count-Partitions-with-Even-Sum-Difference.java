1class Solution {
2    public int countPartitions(int[] nums) {
3        int[] pre=new int[nums.length];
4        int[] suf=new int[nums.length];
5        pre[0]=nums[0];
6        suf[nums.length-1]=nums[nums.length-1];
7        int c=0;
8        for(int i=1;i<nums.length;i++){
9            pre[i]=pre[i-1]+nums[i];
10        }
11        for(int i=nums.length-2;i>-1;i--){
12            suf[i]=suf[i+1]+nums[i];
13        }
14        for(int i=0;i<nums.length-1;i++){
15            if(Math.abs(pre[i]-suf[i+1])%2==0){
16                c++;
17            }
18        }
19        return c;
20    }
21}