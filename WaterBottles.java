package LeetCodeDaily;

public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;


        while(numBottles >= numExchange){
            int exchange = numBottles / numExchange ;
            int rem = numBottles % numExchange;
            total += exchange  ;
            numBottles = rem + exchange ;
        }

        return total ;
    }
}
