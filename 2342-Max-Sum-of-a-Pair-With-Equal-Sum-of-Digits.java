class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int r=-1;
        for(int j:nums){
            int s=0,i=j;
            while(i>0){
                s+=i%10;
                i/=10;
            }
        if(!map.containsKey(s)){
            map.put(s,j);
        }
        else{
            r=Math.max(r,map.get(s)+j);
            map.put(s,Math.max(map.get(s),j));
        }
        
    }
    return r;
}
}