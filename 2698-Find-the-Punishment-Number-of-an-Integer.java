class Solution {
    boolean f=false;
    void sum(ArrayList<Integer> li,int ind,int t,int ps){
        if(ind==li.size()){
        if(ps==t){
            f=true;
        }
        return ;
    }
        int pre=0;
        for(int i=ind;i<li.size();i++){
            pre+=li.get(i);
            sum(li,i+1,t,ps+pre);
            pre*=10;
        }
        return ;
    }
    public int punishmentNumber(int n) {
        if(n<9)
        return 1;
        int cnt=1;
        for(int i=9;i<=n;i++){
            ArrayList<Integer> li=new ArrayList<>();
            int s=i*i;
            while(s>0){
                li.add(s%10);
                s/=10;
            }
            Collections.reverse(li);
            f=false;
            sum(li,0,i,0);
            if(f)
            cnt+=(i*i);
        }
        return cnt;
    }
}