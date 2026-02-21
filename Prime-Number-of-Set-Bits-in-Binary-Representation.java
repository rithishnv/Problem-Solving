1class Solution {
2    public int countPrimeSetBits(int left, int right) {
3        int res=0;
4        for(int i=left;i<=right;i++){
5            if(isPrime(Integer.bitCount(i))){
6                res++;
7            }
8        }
9        return res;
10    }
11    public boolean isPrime(int i){
12        if(i<2)
13        return false;
14        for(int j=2;j<=Math.sqrt(i);j++){
15            if(i%j==0)
16            return false;
17        }
18        return true;
19    }
20}