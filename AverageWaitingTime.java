package LeetCodeDaily;

public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        int totalTime = 0;
        double avgTime = 0;

        for(int[] customer : customers){
            // destructure
            int arrivalTime = customer[0];
            int time = customer[1];

            // if the arrival time is greater than the total change it
            if(totalTime < arrivalTime){
                totalTime = arrivalTime;
            }
            // add the time to cook
            totalTime += time;

            // get the avg time
            avgTime += totalTime - arrivalTime;
        }

        return avgTime / customers.length;
    }
}
