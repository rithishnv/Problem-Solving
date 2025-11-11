class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String str : strs){
            int[]count = getCount(str);
            for(int zeroes = m; zeroes >= count[0]; zeroes--){
                for(int ones = n; ones >= count[1]; ones--){
        dp[zeroes][ones] = Math.max(dp[zeroes][ones], 1 + dp[zeroes - count[0]][ones - count[1]]);
                }  
            }
        }
        return dp[m][n];
    }
    
   int[] getCount(String str){
        int[] count = new int[2];
        for(char c : str.toCharArray()){
            count[c - '0']++;
        }
        return count;
    }
}