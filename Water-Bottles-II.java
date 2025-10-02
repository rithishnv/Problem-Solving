class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int s=numBottles;
        while(numBottles>=numExchange){
            // int r=numBottles%numExchange;
            numBottles-=numExchange;
            s+=1;
            numBottles++;
            // numBottles+=r;
            numExchange++;
            // System.out.println(s);
        }
        // System.out.println(numBottles);
        return s;
    }
}