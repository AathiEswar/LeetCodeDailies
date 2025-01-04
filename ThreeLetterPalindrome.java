package LeetCodeDaily;

import java.util.Arrays;

public class ThreeLetterPalindrome {
    class Solution {
        /*
            INFERENCES :
                find palindrome - lenght 3 , subsequence
                always lowercase
                if str len < 3 return 0

                Possibilities :
                    a b c

                    - aaa
                    - aba
                    - aca

                EXAMPLE :
                    aabca - aaa , aba , aca
                    bbcbaba :
                        - bbb
                        - bab
                        - bcb
                        - aba

                BRUTE FORCE :
                    - use two pointers
                    - check if the i and j are same
                        - if so then add all the letters between them as palindrome
                        - Use HashSet to Store
                    - iterate through the entire array like this
                    - return len of hashset

                    SC - O(n)
                    TC - O(n ^ 2)

                HASHMAP :
                    - use hash map

                    - loop from 0 -> i
                        - if not map contains str[i] :
                            - add str[i] --> 0
                        - if contanins :
                            - get first occurence of str[i] index
                            - get the count of palindrome by = curIndex - firstOcc - 1
                            - update the max of str[i] in map and the count
                                TotalCount - value + count
                    - return TotalCount

                    SC - O(n)
                    TC - O(n ^ 2)

                ARRAY AS HASHMAP :
                    - use array of size 26 fill with -1 ( -1 -> does not exist )
                    - loop from 0 -> i and add the minimum index of each letter to its
                        position index
                    - loop from n -> 0
                        - if index is not -1 its means the element already exist left side
                            and do i - arr[ch] - 1 to get the total palindromes and update
                            count
                        - change arr[ch] to -1

                    - return count

                    SC - O(n)
                    TC - O(n)

        */
        public int countPalindromicSubsequence(String s) {
            int strLen = s.length();

            if(strLen < 3){
                return 0;
            }

            int[] lowIdx = new int[26];
            int[] highIdx = new int[26];

            Arrays.fill(lowIdx , -1);
            Arrays.fill(highIdx , -1);

            for(int i = 0 ; i<strLen ;i++){
                int chIdx = s.charAt(i) - 'a';
                if(lowIdx[chIdx] == -1){
                    lowIdx[chIdx] = i;
                }
                highIdx[chIdx] = i;
            }

            int totalCount = 0;
            for(int i = 0 ; i< 26 ; i++ ){
                int high = highIdx[i];
                int low = lowIdx[i];

                boolean[] visited = new boolean[26];
                int count = 0;
                for(int j = low+1 ; j<high;j++){
                    if(!visited[ s.charAt(j) - 'a' ]) {
                        visited[ s.charAt(j) - 'a'] = true;
                        count++;
                    }
                }
                totalCount += count;
            }

            return totalCount;

        }
    }
}
