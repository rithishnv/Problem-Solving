class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int li=map.getOrDefault(nums[i]*nums[j],0)+1;
                map.put(nums[i]*nums[j],li);
            }
        }
        int cnt=0;
        for(int c:map.values()){
            // int c=map.get(i).size()/2;
            // if(c>1){
                cnt+=c*(c-1)*4;
                // cnt+=(c*(c-1)/2)*8;
            // }
            // cnt++;
        }
        // System.out.println(/4);
        return cnt;
    }
}