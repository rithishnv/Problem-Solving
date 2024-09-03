class Solution {
    public int getLucky(String s, int k) {
        int sum=0,s1;
        for(int i=0;i<s.length();i++){
            s1=(int)(s.charAt(i)-96);
            while(s1>0){
                sum+=s1%10;
                s1/=10;
            }
        }
        k--;
        while(k-->0){
            s1=0;
            while(sum>0){
            s1+=sum%10;
            sum/=10;
        }
        sum=s1;
        }
        return sum;
    }
}