class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int rem=0,exchange=0,drinkable=0;
        drinkable+=numBottles;
        while(numBottles>=numExchange){
           exchange=numBottles/numExchange;
           rem=numBottles%numExchange;
           numBottles=exchange+rem;
           drinkable+=exchange;
        }
        return drinkable;
    }
}