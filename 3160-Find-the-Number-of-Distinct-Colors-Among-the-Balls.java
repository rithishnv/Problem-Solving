class Solution {
    public int[] queryResults(int limit, int[][] queries) {
       Map<Integer,Integer> ball=new HashMap<Integer,Integer>();
        Map<Integer,Integer> col=new HashMap<Integer,Integer>();
       int[] r=new int[queries.length];
       int o=0;
       for(int[] i:queries){
       if(ball.containsKey(i[0])){
        int n=ball.get(i[0]);
        col.put(n,col.get(n)-1);
        if(col.get(n)==0)
        col.remove(n);
       }
       ball.put(i[0],i[1]);
       col.put(i[1],col.getOrDefault(i[1],0)+1);
        r[o++]=col.size();
       }
       return r;
    }
}