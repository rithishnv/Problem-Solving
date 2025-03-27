class Solution {
    public int minimumIndex(List<Integer> nums) {
        int max=0;
        int num=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                int f=map.get(i);
                map.put(i,f+1);
                if(f+1>max){
                    max=f+1;
                    num=i;
                }
            }
            else{
                map.put(i,1);
            }
        }
        int len=0,j=0;
        for(int i:nums){
            if(i==num){
                len++; //count on left 
                max--; //count on right
                if(len>(j+1)/2 && max>(nums.size()-1-j)/2)
                return j; 
            }
            j++;
        }
        return -1;
    }
}