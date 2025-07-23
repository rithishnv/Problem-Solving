class Solution {
    public int maximumGain(String s, int x, int y) {
        char a='a',b='b';
        int n=s.length();
        char[] arr=s.toCharArray();
        if(n==1)
        return 0;
        if(x<y){
            int t=x;
            x=y;
            y=t;
            a='b';
            b='a';
        }
        int acnt=0,bcnt=0,res=0;
        for(int i=0;i<n;i++){
            if(arr[i]==a){
                acnt++;
            }
            else if(arr[i]==b){
                if(acnt>0){
                    acnt--;
                    res+=x;
                }
                else
                bcnt++;
            }
            else{
                res+=Math.min(acnt,bcnt)*y;
                acnt=0;
                bcnt=0;
            }
        }
        res+=Math.min(acnt,bcnt)*y;
        return res;
    }
}