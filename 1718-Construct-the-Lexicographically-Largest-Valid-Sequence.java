class Solution {
    boolean str(int ind,int n,int[] r,boolean[] v){
        if(ind>=r.length)
        return true;
        if(r[ind]!=-1)
        return str(ind+1,n,r,v);
        for(int i=n;i>0;i--){
            if(v[i])
            continue;
            v[i]=true;
            r[ind]=i;
            if(i==1){
                if(str(ind+1,n,r,v))
                return true;
            }
            else{
                int j=ind+i;
                if(j<r.length && r[j] ==-1){
                    r[j]=i;
                    if(str(ind+1,n,r,v))
                    return true;
                    r[j]=-1;
                }
            }
            v[i]=false;
            r[ind]=-1;
        }
        return false;
    }
    public int[] constructDistancedSequence(int n) {
        int[] r=new int[n*2-1];
        boolean[] v=new boolean[n+1];
        Arrays.fill(r,-1);
        str(0,n,r,v);
        return r;
    }
}