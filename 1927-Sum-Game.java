class Solution {
    public boolean sumGame(String num) {
        int ls=0,rs=0,q1=0,q2=0;
        int n=num.length();
        int l=0,r=n-1;
        while(l<r){
            if(Character.isDigit(num.charAt(l))){
                ls+=num.charAt(l)-'0';
            }
            else{
                q1++;
            }
            if(Character.isDigit(num.charAt(r))){
                rs+=num.charAt(r)-'0';
            }
            else{
                q2++;
            }
            l++;
            r--;
        }
        return (ls-rs)*2!=9*(q2-q1);
    }
}