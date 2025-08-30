class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char val=board[i][j];
                if(val!='.'){
                String r="r"+i+""+val;
                String c="c"+j+""+val;
                String sub=(i/3)+""+(j/3)+val;
                if(!set.add(r) || !set.add(c) || !set.add(sub))
                return false;
                }
            }
        }
        return true;
    }
}