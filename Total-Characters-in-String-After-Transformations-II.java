class Solution {
    int mod=1000000007;
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[][] temp=new long[26][26];
        long trans=t;
        for(int i=0;i<26;i++){
            for(int j=0;j<nums.get(i);j++){
                int nxt=(i+1+j)%26;
                temp[i][nxt]++;
            }
        }
        long[][] res=power(temp,trans);
        long len=0;
        for(char j:s.toCharArray()){
            int ind=j-'a';
            long h=0;
            for(int i=0;i<26;i++){
                h=(h+res[ind][i])%mod;
            }
            len=(len+h)%mod;
        }
        return (int)len%mod;
    }
    public long[][] power(long[][] temp,long trans){
        int n=26;
        long[][] pmat=new long[n][n];
        for(int i=0;i<26;i++){
            pmat[i][i]=1;
        }
        while(trans>0){
            if(trans%2==1){
                pmat=multiplication(pmat,temp);
            }
            temp=multiplication(temp,temp);
            trans/=2;
        }
        return pmat;
    }
    public long[][] multiplication(long[][] a,long[][] b){
        int n=26;
        long[][] res=new long[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    res[i][j]=(res[i][j]+a[i][k]*b[k][j])%mod;
                }
            }
        }
        return res;
    }
}