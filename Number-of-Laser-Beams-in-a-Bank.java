class Solution {
    public int numberOfBeams(String[] bank) {
        int prev=0,c=0,res=0;
        for(int i=0;i<bank.length;i++){
            for(char j:bank[i].toCharArray()){
                if(j=='1')
                c++;
            }
            res+=(prev*c);
            if(c!=0){
            prev=c;
            c=0;
            }
        }
        return res;
    }
}