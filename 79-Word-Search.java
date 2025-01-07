class Solution {
    public boolean check(char[][] board,String word,int i,int j,int s,boolean[][] v){
    if(i<0||j<0||i>=board.length||j>=board[0].length||v[i][j] ||board[i][j]!=word.charAt(s))
        return false;
        if(s==word.length()-1)
        return true;
        v[i][j]=true;
        boolean r=check(board,word,i+1,j,s+1,v)||check(board,word,i,j+1,s+1,v)||check(board,word,i-1,j,s+1,v)||check(board,word,i,j-1,s+1,v);
        v[i][j]=false;
        return r;
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] v=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(check(board,word,i,j,0,v))
                return true;
            }
        }
        return false;
    }
}