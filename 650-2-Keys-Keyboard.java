class Solution {
    public int minSteps(int n) {
        int c=0,i=2;
        while(n>1){
            while(n%i==0){
                c+=i;
                n/=i;
            }
            i++;
        }
        return c;

    }
}