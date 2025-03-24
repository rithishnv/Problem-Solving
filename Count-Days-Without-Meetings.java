class Solution {
    public int countDays(int days, int[][] meetings) {
        int st=1;
        Arrays.sort(meetings,(a,b)->(a[0]-b[0]));
        int end=meetings[0][1];
        int res=meetings[0][0]-1;
        for(int i=1;i<meetings.length;i++){
            if(meetings[i][0]<=end){
                end=Math.max(end,meetings[i][1]);
            }
            else{
                res+=meetings[i][0]-end-1;
                end=meetings[i][1];
            }
        }
        res+=days-end;
        return res;
    }
}