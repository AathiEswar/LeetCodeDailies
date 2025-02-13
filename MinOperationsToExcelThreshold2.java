package LeetCodeDaily;

import java.util.PriorityQueue;

public class MinOperationsToExcelThreshold2 {
    class Solution {
        /*
            BRUTE FORCE :
                - Use Min Heap

                add all elements to min heap
                have a count
                loop untill queue not empty
                    remove first two elements if they are greater or equals k
                     else stop the loop
                    do the operation and enqueue it again to queue
                    count++;
                return count

        */
        public int minOperations(int[] nums, int k) {
            PriorityQueue<Long> heap = new PriorityQueue<>();

            for(long num : nums){
                heap.offer(num);
            }

            int count = 0;
            while(heap.peek() < k){
                long num1 = heap.poll();

                if(num1 >= k){
                    return count;
                }

                long num2 = heap.poll();

                heap.offer( num1 * 2 + num2);
                count++;
            }

            return count;
        }
    }
}
