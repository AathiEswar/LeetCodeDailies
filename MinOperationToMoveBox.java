package LeetCodeDaily;

public class MinOperationToMoveBox {
    class Solution {
        /*
            INFERENCES :
                0 -> no ball
                1 -> ball
                Minimum operations to get all balls to index i

            BRUTE FORCE :
                - count[] = 0
                - Iterate through the boxes
                    - totalCount = 0
                    - iterate through every other element in boxes
                        - if its 1 :
                            totalCount += j - i
                    count[i] = totalCount
                return count

                SC - O(1)
                TC - O(n ^ 2)

            OPTIMIZE :
                - Algorithm to reduce time ?
                - extra space ? array , hashset , hashmap ?

            SOLUTION 1 :
                - have prefix and suffix array , containing no of moves
                - if( len of boxes < 2) return new int[]
                - oneCount = 0
                - iterate through boxes 1 -> n :
                    - prefix[i] = prefix[i-1] + oneCount
                    - if boxes[i-1] == 1 :
                        oneCount += 1
                        prefix[i]++

                - oneCount = 0
                - iterate through boxes n-1 -> 0 :
                    - prefix[i] = prefix[i+1] + oneCount
                    - if boxes[i+1] == 1 :
                        oneCount += 1
                        suffix[i]++

                - iterate through res array :
                    res[i] = prefix[i] + suffix[i]

                return res;

        */
        public int[] minOperations(String boxes) {

            int n = boxes.length();

            // If the length of boxes is less than 2, return an empty array
            if (boxes.length() < 2) return new int[n];

            int[] prefix = new int[n];
            int[] suffix = new int[n];
            int[] res = new int[n];

            // Calculate prefix array
            int oneCount = 0;
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] + oneCount;
                if (boxes.charAt(i - 1) == '1') {
                    oneCount++;
                    prefix[i]++;
                }
            }

            // Calculate suffix array
            oneCount = 0;
            for (int i = n - 2; i >= 0; i--) {
                suffix[i] = suffix[i + 1] + oneCount;
                if (boxes.charAt(i + 1) == '1') {
                    oneCount++;
                    suffix[i]++;
                }
            }

            // Calculate the result array
            for (int i = 0; i < n; i++) {
                res[i] = prefix[i] + suffix[i];
            }

            return res;
        }
    }
}
