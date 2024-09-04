class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        for(int i=0;i<score.length;i++){
            int c=i;
            for(int j=i+1;j<score.length;j++){
                if(score[j][k]>score[c][k])
                c=j;
            }
                int[] t=score[c];
                score[c]=score[i];
                score[i]=t;
            }
        return score;
    }
}