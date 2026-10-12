class Solution {
    int mod = (int)1e9+7;
    public int maxSum(List<Integer> nums, int k) {
        int n = nums.size();
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0;i<n;i++){
            int x = nums.get(i);
            int val = 1;
            while(x>0){
                int rem = x%2;
                if(rem==1){
                    max = Math.max(max,val);
                    map.put(val,map.getOrDefault(val,0)+1);
                }
                x=x/2;
                val++;
            }
        }
        long ans = 0L;
        for(int i=0;i<k;i++){
            long val = 0L;
            for(int j=max;j>0;j--){
                if(!map.containsKey(j)){
                    val = val*2;
                }
                else{
                    if(map.get(j)>0){
                        val = val*2+1;
                        map.put(j,map.get(j)-1);
                    }
                    else val = val*2;
                }
            }
            long sq=(val%mod*val%mod)%mod;
            ans = (ans%mod + sq%mod)%mod;
        }
        ans = ans%mod;
        return (int)(ans%mod);
    }
}