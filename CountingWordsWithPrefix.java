package LeetCodeDaily;

public class CountingWordsWithPrefix {
    class Solution {
        /*
            BRUTE FORCE :
                - iterate through words
                 - check if the first substring is pref uisng a sub count
                    - if so increase overall count
                - return count

                SC - O(1)
                TC - O( n * m )
        */
        public int prefixCount(String[] words, String pref) {
            int count = 0 ;

            for(String word : words){
                if(word.startsWith(pref)){
                    count++;
                }
            }

            return count;
        }
    }
}
