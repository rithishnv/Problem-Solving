class Solution {
    public void search(int i,List<List<Integer>> rooms,boolean[] visited){
        visited[i]=true;
        for(int j:rooms.get(i)){
            if(!visited[j])
            search(j,rooms,visited);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        search(0,rooms,visited);
        for(boolean i:visited){
            if(!i)
              return false;
        }
        return true;
    }
}