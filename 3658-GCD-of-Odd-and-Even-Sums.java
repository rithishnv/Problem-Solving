class Solution {
    public int gcdOfOddEvenSums(int n) {
        int o=0,e=0;
        for(int i=1;i<=2*n;i++){
            o+=i++;
            e+=i;
        }
        return gcd(e,o);
    }
    public int gcd(int o,int e){
        return e!=0?gcd(e,o%e):o;
    }
}