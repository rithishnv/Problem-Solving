class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
       Queue<Integer> q=new LinkedList<>();
       int m=status.length;
    //    int[] arr=new int[m];
       for(int i:initialBoxes){
        q.add(i);
        // status[i]=0;
       }
       int cnt=0;
       int res=0;
       while(cnt!=q.size() && !q.isEmpty()){
        int v=q.poll();
        if(status[v]==0){
        cnt++;
        q.add(v);
        continue;
       }
    //    status[v]=0;
       cnt=0;
        for(int j:containedBoxes[v]){
            q.add(j);
        }
        for(int j:keys[v]){
          status[j]=1;
        }
        res+=candies[v];
       }
      return res;
    }
}