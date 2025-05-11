class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int c=0;
        for(int i:arr){
           if(i%2!=0){
            if(++c>=3)
             return true;
            continue;
           }
           c=0;
        }
        return false;
    }
}