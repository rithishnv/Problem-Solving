class Solution {
    int mod=1000000007;
    List<int[]> li=new ArrayList<>();
    public int colorTheGrid(int m, int n) {
        ways(m,0,0,new int[m]);
        m=li.size();
        int[][] dp=new int[n][m];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        int res=0;
        for(int i=0;i<m;i++){
            res+=check(dp,1,i,n,m);
            res%=mod;
        }
        return res%mod;
    }
    public int check(int[][] dp,int i,int j,int n,int m){
        if(i==n){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        for(int a=0;a<m;a++){
            if(cond(a,j)){
                ans+=check(dp,i+1,a,n,m);
                ans%=mod;
            }
        }
        return dp[i][j]=ans%mod;
    }
    public boolean cond(int i,int j){
        int n=li.get(i).length;
        for(int x=0;x<n;x++){
            if(li.get(i)[x]==li.get(j)[x])
            return false;
        }
        return true;
    }
    public void ways(int m,int prev,int cur,int[] arr){
        if(cur==m){
            li.add(Arrays.copyOf(arr,m));
            return;
        }

        for(int i=1;i<4;i++){
            if(i!=prev){
                arr[cur]=i;
                ways(m,i,cur+1,arr);
                arr[cur]=0;
            }
        }
    }
}