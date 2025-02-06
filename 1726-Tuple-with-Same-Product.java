class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
         int cnt=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                cnt+=8*map.getOrDefault(nums[i]*nums[j],0);
                map.put(nums[i]*nums[j],map.getOrDefault(nums[i]*nums[j],0)+1);
                // map.put(nums[i]*nums[j],li);
            }
        }
       
        // for(int c:map.values()){
            // int c=map.get(i).size()/2;
            // if(c>1){
                // cnt+=c*(c-1)*4;
                // cnt+=(c*(c-1)/2)*8;
            // }
            // cnt++;
        // }
        // System.out.println(/4);
        return cnt;
    }
}