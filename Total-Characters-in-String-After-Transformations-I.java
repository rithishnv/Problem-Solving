class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int mod=1000000007;
        int[] arr=new int[26];
        for(char i:s.toCharArray()){
            arr[i-'a']++;
        }
        while(t-->0){
            int z=arr[25];
            arr[25]=0;
            for(int i=24;i>-1;i--){
                arr[i+1]=arr[i];
                arr[i]=0;
            }
            if(z>0){
                arr[0]=(arr[0]+z)%mod;
                arr[1]=(arr[1]+z)%mod;
            }
        }
        int len=0;
        for(int i:arr){
            len=(len+i)%mod;
        }
        return len;
    }
}