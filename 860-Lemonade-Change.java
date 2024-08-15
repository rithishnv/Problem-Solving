class Solution {
    public boolean lemonadeChange(int[] bills) {
        int c=0,t=0;
        if(bills[0]!=5)
        return false;
        for(int i:bills){
            if(i==5)
             c++;
            else if(i==10&&c>0){
                c--;
                t++;
            }
            else if(i==20){
                if(t>0&&c>0){
                    t--;
                    c--;
                }
                else if(t==0&&c>=3)
                c-=3;
                else
                 return false;
            }
            else
             return false;
        }
        return true;
    }
}