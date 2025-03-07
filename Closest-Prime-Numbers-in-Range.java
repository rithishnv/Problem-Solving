class Solution {
    List<Integer> li=new ArrayList<>();
    int prev=Integer.MAX_VALUE;
    public boolean check(int n){
        if(n==1)
        return false;
        if(n==2 ||n==3)
        return true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
            return false;
        }
        return true;
    }
    public int[] closestPrimes(int left, int right) {
        int[] res=new int[2];
        Arrays.fill(res,-1);
        for(int i=left;i<=right;i++){
            if(check(i))
            li.add(i);
        }
        for(int i=0;i<li.size()-1;i++){
            if(li.get(i+1)-li.get(i)<prev){
                prev=li.get(i+1)-li.get(i);
                res[0]=li.get(i);
                res[1]=li.get(i+1);
            }
        }
        return res;
    }
}