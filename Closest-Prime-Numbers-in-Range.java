class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] p=new boolean[right+1];
        Arrays.fill(p,true);
        List<Integer> li=new ArrayList<>();
        int prev=Integer.MAX_VALUE;
        p[0]=false;
        p[1]=false;
        int[] res=new int[2];
        Arrays.fill(res,-1);
        for(int i=2;i*i<=right;i++){
            if(p[i]){
            for(int j=i+i;j<=right;j+=i){
                p[j]=false;
            }
            }
        }
        for(int i=left;i<=right;i++){
        if(p[i])
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