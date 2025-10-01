class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int s=numBottles;
        while(numBottles>=numExchange){
            int r=numBottles%numExchange;
            numBottles/=numExchange;
            s+=numBottles;
            numBottles+=r;
        }
        return s;
    }
}