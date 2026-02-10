1class Solution {
2    public int longestBalanced(int[] nums) {
3        int n=nums.length;
4        int res=0;
5        for(int i=0;i<n;i++){
6            int e=0,o=0;
7            Set<Integer> set=new HashSet<>();
8            for(int j=i;j<n;j++){
9                if(set.add(nums[j])){
10                if(nums[j]%2==0)
11                e++;
12                else
13                o++;
14                }
15                if(e==o){
16                    res=Math.max(j-i+1,res);
17                }
18            }
19            if(e==o){
20                    res=Math.max(n-i,res);
21                }
22        }
23        return res;
24    }
25}