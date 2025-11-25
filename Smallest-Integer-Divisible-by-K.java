class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0 || k%5==0)
        return -1;
        long t=0;
        int a=1;
        while(a<=k){
            t=((t*10)+1)%k;
            if(t==0)
            return a;
            a++;
        }
        return -1;
    }
}