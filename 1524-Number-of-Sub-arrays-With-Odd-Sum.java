class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod=1000000007;
        int odd=0,even=0,res=0,sum=0;
        for(int i:arr){
            sum+=i;
            if(sum%2!=0){
                res=(res+1+even)%mod;
                odd++;
            }
            else{
                res=(res+odd)%mod;
                even++;
            }
        }
        return res;
    }
}