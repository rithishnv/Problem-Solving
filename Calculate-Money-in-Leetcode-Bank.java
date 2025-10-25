class Solution {
    public int totalMoney(int n) {
        int i=1,j=1,s=0,t=0;
        while(n-->0){
            s+=i;
            i++;
            t++;
            if(t==7){
                j++;
                i=j;
                t=0;
            }
        }
        return s;
    }
}