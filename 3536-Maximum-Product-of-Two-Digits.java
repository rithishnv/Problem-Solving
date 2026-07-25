class Solution {
    public int maxProduct(int n) {
        int n1=0,n2=0;
        while(n>0){
            if(n%10>n1){
                if(n2<n1)
                n2=n1;
                n1=n%10;
            }
            else if(n%10>n2){
                n2=n%10;
            }
            n/=10;
        }
        return n1*n2;
    }
}