class Solution {
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    public boolean solve(char[][] board,int i,int j){
        if(i==board.length)
        return true;
        if(board[0].length==j)
        return solve(board,i+1,0);
        if(board[i][j]!='.')
        return solve(board,i,j+1);
        for(char num='1';num<='9';num++){
            if(check(board,i,j,num)){
                board[i][j]=num;
                if(solve(board,i,j+1))
                return true;
                board[i][j]='.';
            }
        }
        return false;
    }
    public boolean check(char[][] board,int i,int j,char num){
        for(int k=0;k<board.length;k++){
            if(board[i][k]==num)
            return false;
            if(board[k][j]==num)
            return false;
            int x=3*(i/3)+k/3;
            int y=3*(j/3)+k%3;
            if(board[x][y]==num)
            return false;
        }
        return true;
    }
}