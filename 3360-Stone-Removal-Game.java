class Solution {
    public boolean canAliceWin(int n) {
        int t=10;
        while(n>=t){
            n-=t;
            t--;
        }
        return (t%2)!=0;
    }
}