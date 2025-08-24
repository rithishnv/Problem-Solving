class Solution {
    public int longestSubarray(int[] nums) {
        int cnt=0;
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)
            cnt++;
            else if(nums[i]==0 && cnt==0){
                li.add(0);
            }
            else{
                li.add(cnt);
                cnt=0;
                li.add(cnt);
            }
        }
        if(cnt!=0)
        li.add(cnt);
        cnt=0;
        int r=0;
        if(li.size()==1){
            r=((li.get(0)-1)>0)?li.get(0)-1:0;
        }
        else if(li.size()<=3){
            for(int i:li)
            r+=i;
        }
        else{
            for(int i=0;i<li.size();i++){
                cnt+=li.get(i);
                if(i>=3){
                    cnt-=li.get(i-3);
                }
                r=Math.max(r,cnt);
            }
        }
        // System.out.println(li);
        return r;
    }
}