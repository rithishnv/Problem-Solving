class Solution {
    String r="";
    int i=-1;
    void check(int n,String[] nums,String s){
        if(n==s.length()){
            if(++i>=nums.length)
            r=new String(s);
            else if(!nums[i].equals(s))
            r=new String(s);
            return;
        }
        for(int i=0;i<2;i++){
            StringBuilder sb=new StringBuilder(s);
            sb.append(i);
            check(n,nums,sb.toString());
            if(!r.equals(""))
            return;
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
    public String findDifferentBinaryString(String[] nums) {
        Arrays.sort(nums);
        check(nums[0].length(),nums,"");
        return r;
    }
}