class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drink=numBottles;
        while(numBottles>=numExchange){
           ++drink;
           numBottles-=numExchange;
           numExchange++;
           numBottles++;
        }
        return drink;
    }
}