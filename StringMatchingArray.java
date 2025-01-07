package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StringMatchingArray {
    class Solution {

        /*
            BRUTE FORCE :
                - Sort the array
                - iterate through the array
                    - iterate for each word
                        - if contains then add to res and break

                - return res

                SC - O(n)
                TC - O( nlogn ) + O( n^2 . m)
        */
        public List<String> stringMatching(String[] words) {
            HashSet<String> set = new HashSet<>();
            int len = words.length;
            Arrays.sort(words , (a, b) -> a.length() - b.length() );

            for(int i = 0 ; i< len-1 ; i++){
                for(int j = i+1 ; j<len ; j++ ){
                    if( words[j].contains(words[i])){
                        set.add(words[i]);
                    }
                }
            }

            return new ArrayList<>(set);

        }
    }
}
