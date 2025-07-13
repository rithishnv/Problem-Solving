class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int n=players.length,t=trainers.length;
        int res=0,i=0,j=0;
        while(i<n && j<t){
            int y=j;
            while(j<t && players[i]>trainers[j]){
                j++;
            }
            if(j<t && players[i]<=trainers[j]){
                res++;
                j++;
            }
            i++;
        }
        return res;
    }
}