class Solution {
    public int maximum69Number (int num) {
        int t=0;
        while(num>0){
            t=t*10+num%10;
            num/=10;
        }
        int f=0;
        while(t>0){
            if(t%10==6 && f==0){
                num=num*10+9;
                f=1;
                t/=10;
                continue;
            }
            num=num*10+t%10;
            t/=10;
        }
        return num;
    }
}