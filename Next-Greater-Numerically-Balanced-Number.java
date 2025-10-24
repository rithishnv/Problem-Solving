class Solution {
    int[] arr=new int[10];
    public long dfs(int n,long t,int l){
        if(l==0){
            for(int i=1;i<=9;i++){
                if(arr[i]!=i && arr[i]!=0){
                    return 0;
                }
            }
            return t>n?t:0;
        }
        long v=0;
        for(int i=1;v==0 && i<=9;i++){
            if(arr[i]>0 && arr[i]<=l){
                arr[i]--;
                v=dfs(n,t*10+i,l-1);
                arr[i]++;
            }
        }
        return v;
    }
    public int nextBeautifulNumber(int n) {
        for(int i=0;i<10;i++){
            arr[i]=i;
        }
      int l=String.valueOf(n).length();
      long res=dfs(n,0,l);
      if(res==0){
        res=dfs(n,0,l+1);
      }
      return (int)res;
    }
}