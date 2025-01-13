class Solution {
    public int minimumLength(String s) {
        int[] a=new int[27];
        for(int i:s.toCharArray()){
            a[i-97]++;
        }
        for(int i=0;i<26;i++){
            while(a[i]>=3){
                a[i]-=2;
            }
        }
        int sum=0;
        for(int i:a)
        sum+=i;
        return sum;
    }
}