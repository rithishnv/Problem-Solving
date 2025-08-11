class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod=(int)1e9+7;
        List<Integer> li=new ArrayList<>();
        int c=0;
        while(n>0){
            if(n%2==1){
                li.add((int)Math.pow(2,c));
            }
            n/=2;
            c++;
        }
        int[] res=new int[queries.length];
        int k=0;
        for(int[] i:queries){
            long ans=1;
            for(int j=i[0];j<=i[1];j++){
                ans=(ans*li.get(j))%mod;
            }
            res[k++]=(int)ans;
        }
        return res;
    }
}