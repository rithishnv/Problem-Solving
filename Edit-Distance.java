class Solution {
    int edit(int i,int j,String s1,String s2,int[][] dp){
        if(i<0)
        return j+1;
        if(j<0)
        return i+1;
        if(dp[i][j]!=-1)
        return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
        return edit(i-1,j-1,s1,s2,dp);
        return dp[i][j]=1+Math.min(edit(i-1,j,s1,s2,dp),
        Math.min(edit(i-1,j-1,s1,s2,dp),edit(i,j-1,s1,s2,dp)));
    }
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()][word2.length()];
        for(int[] i:dp)
        Arrays.fill(i,-1);
        return edit(word1.length()-1,word2.length()-1,word1,word2,dp);
    }
}