package LeetCodeDaily;

public class RemoveAllOccOfSubString {
    class Solution {
        /*
            INFERENCE :
                s and part are strings of lowercase with atlest len 1
                wht if len(s) < len(part) ? return s
                what if part == "" return s

            BRUTE FORCE :
                - check for edge cases and return
                    if len(s) < len(part) ? return s
                    if part == "" return s
                - while(s.contains(part))
                    - index = s.indexOf(part);
                    - s.remove(index , index + len(part))

                return s

                SC : O(n) for string buffer
                TC : O( n * k ) for checking part in s and removing it
        */
        public String removeOccurrences(String s, String part) {
            StringBuilder sb = new StringBuilder(s);

            while(sb.indexOf(part) != -1){
                int index = sb.indexOf(part);
                sb.delete(index , index + part.length());
            }

            return sb.toString();
        }
    }
}
