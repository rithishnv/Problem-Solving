class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int cnt=0;
        for(int i=0;i<fruits.length;i++){
            for(int j=0;j<fruits.length;j++){
                if(fruits[i]<=baskets[j]){
                    baskets[j]=0;
                    cnt++;
                    break;
                }
            }
        }
        return baskets.length-cnt;
    }
}