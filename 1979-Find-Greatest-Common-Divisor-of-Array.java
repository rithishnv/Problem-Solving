class Solution {
    public int findGCD(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i:nums){
            min=Math.min(min,i);
            max=Math.max(max,i);
        }
        return gcd(max,min);
    }
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}