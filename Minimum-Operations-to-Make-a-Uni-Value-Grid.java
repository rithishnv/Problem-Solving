class Solution {
    public int minOperations(int[][] grid, int x) {
        int max=0;
        List<Integer> li=new ArrayList<>();
        int a=grid[0][0]%x;
        for(int[] i:grid){
            for(int j:i){
                if(j%x!=a)
                return -1;
                li.add(j);
            }
        }
        Collections.sort(li);
        int t=li.get(li.size()/2);
        int cnt=0;
        for(int[] i:grid){
            for(int j:i){
                cnt+=Math.abs(j-t)/x;
            }
        }
        return cnt;
    }
}