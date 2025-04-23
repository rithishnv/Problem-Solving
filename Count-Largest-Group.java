class Solution {
    public int digit(int n){
        int r=0;
        while(n>0){
            r+=n%10;
            n/=10;
        }
        return r;
    }
    public int countLargestGroup(int n) {
        int[] arr=new int[37];
        int res=0,max=0;
        for(int i=1;i<=n;i++){
            max=Math.max(max,++arr[digit(i)]);
        }
        for(int i:arr){
            if(i==max)
            res++;
        }
        return res;
    }
}