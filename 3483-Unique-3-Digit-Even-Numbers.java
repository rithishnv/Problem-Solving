class Solution {
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        boolean[] v=new boolean[n];
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            if(digits[i]==0){
                continue;
            }
            v[i]=true;
            int t=digits[i];
            check(digits,n,v,t,2,set);
            v[i]=false;
        }
        return set.size();
    }
    public void check(int[] digits,int n,boolean[] v,int t,int cnt,Set<Integer> set){
        if(cnt==0){
            if(t%2==0){
                set.add(t);
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(v[i]){
                continue;
            }
            v[i]=true;
            t=(t*10)+digits[i];
            check(digits,n,v,t,cnt-1,set);
            t/=10;
            v[i]=false;
        }
        return;
    }
}