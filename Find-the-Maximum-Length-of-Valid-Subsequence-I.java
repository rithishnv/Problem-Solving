class Solution {
    public int maximumLength(int[] nums) {
       int even=0,odd=0,both=0,c=nums[0]%2;
       for(int i:nums){
        if(i%2==0)
        even++;
        else
        odd++;
        if(i%2==c){
            both++;
            c=1-c;
        }
       }
       return Math.max(even,Math.max(odd,both));
    }
}