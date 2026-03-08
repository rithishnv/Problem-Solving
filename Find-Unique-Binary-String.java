1class Solution {
2    String r="";
3    int i=-1;
4    void check(int n,String[] nums,String s){
5        if(n==s.length()){
6            if(++i>=nums.length)
7            r=new String(s);
8            else if(!nums[i].equals(s))
9            r=new String(s);
10            return;
11        }
12        for(int i=0;i<2;i++){
13            StringBuilder sb=new StringBuilder(s);
14            sb.append(i);
15            check(n,nums,sb.toString());
16            if(!r.equals(""))
17            return;
18            sb.deleteCharAt(sb.length()-1);
19        }
20        return;
21    }
22    public String findDifferentBinaryString(String[] nums) {
23        Arrays.sort(nums);
24        check(nums[0].length(),nums,"");
25        return r;
26    }
27}