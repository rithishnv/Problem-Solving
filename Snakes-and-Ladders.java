class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int[] arr=new int[n*n+1];
        Arrays.fill(arr,-1);
        arr[1]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int x=q.poll();
            for(int i=1;i<=6;i++){
                int t=x+i;
                int row=(t-1)/n;
                int col=(t-1)%n;
                int v=board[n-1-row][(row%2==1)?(n-1-col):col];
                int y=(v>0)?v:t;
                if(y==n*n)
                return arr[x]+1;
                if(arr[y]==-1){
                    arr[y]=arr[x]+1;
                    q.add(y);
                }
            }
        }
        return -1;
    }
}