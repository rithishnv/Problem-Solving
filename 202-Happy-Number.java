class Solution {
    public boolean isHappy(int n) {
        int s=0;
        while(n!=0){
                int d=n%10;
                s+=(d*d);
                n/=10;
            }
            if(s>4)
             return isHappy(s);
            else
            return s==1;
    }
}