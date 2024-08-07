class Solution {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            for(int j=2;j*j<=i;j++){
                while(i%j==0){
                    set.add(j);
                     i/=j;
                }
            }
            if(i>1)
            set.add(i);
        }
        return set.size();
    }
}