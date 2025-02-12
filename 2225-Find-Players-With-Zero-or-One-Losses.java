class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> li=new ArrayList<>();
        li.add(new ArrayList<Integer>());
        li.add(new ArrayList<Integer>());
        int[] win=new int[100001];
        int[] loss=new int[100001];
        for(int[] i:matches){
            win[i[0]]++;
            loss[i[1]]++;
        }
        for(int i=0;i<win.length;i++){
            if(loss[i]==0 && win[i]!=0)
            li.get(0).add(i);
            else if(loss[i]==1)
            li.get(1).add(i);
        }
        return li;
    }
}