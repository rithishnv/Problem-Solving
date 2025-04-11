class Solution {
    public boolean palindrome(int n){
        int l=0;
        int i=n;
        while(i!=0){
            i/=10;
            l++;
        }
        int s=0;
        if(l%2!=0)
        return false;
        while(i!=l/2){
            s+=n%10;
            n/=10;
            i++;
        }
        while(n!=0){
            s-=n%10;
            n/=10;
        }
        return s==0;
    }
    public int countSymmetricIntegers(int low, int high) {
        if(high<=10)
        return 0;
        int cnt=0;
        for(int i=low;i<=high;i++){
            if(palindrome(i))
            cnt++;
        }
        return cnt;
    }
}