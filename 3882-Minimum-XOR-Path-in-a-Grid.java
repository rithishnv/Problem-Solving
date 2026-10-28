class Solution {
    public int minCost(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Set<Integer> [][] dp = new HashSet[r][c];
        for(int i=0;i< r ;i++){
            for(int j=0;j< c; j++){
                dp[i][j]= new HashSet<>();
            }
        }
        dp[0][0].add(grid[0][0]);
        for(int i=0;i< r ;i++){
            for(int j=0;j< c;j++){
                if(i==0 && j==0){
                    continue;
                }
                if(i > 0 ){
                    for(int xor : dp[i-1][j]){
                        dp[i][j].add(xor ^ grid[i][j]);
                    }
                }
                if(j >0 ){
                    for(int xor : dp[i][j-1]){
                        dp[i][j].add(xor ^ grid[i][j]);
                    }
                }
            }
        }
        return Collections.min(dp[r-1][c-1]);
    }
}