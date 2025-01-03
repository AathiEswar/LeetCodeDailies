package LeetCodeDaily;

public class NoOfWaysToSplitArray {
    class Solution {
    /*
        BRUTE FORCE :
            - Find Suffix Sum
            - calculate prefix sum and check the condition in the same Loop
            while iterating the count
            - retrn count

        OPTIMIZED :
            - find the total sum
            - for current element i , suffix sum is totalSum - nums[0 to i]
            - find the suffix Sum and use the compliment
    */

        public int waysToSplitArray(int[] nums) {
            int len = nums.length;

            long prefixSum = 0 ;
            long suffixSum = 0 ;
            int count = 0 ;

            for(int i = 0 ; i<len ; i++){
                suffixSum += nums[i];
            }

            for(int i = 0 ; i<len-1 ; i++){
                prefixSum += nums[i];
                suffixSum -= nums[i];

                if(prefixSum >= suffixSum ){
                    count++;
                }
            }

            return count;
        }
    }
}
