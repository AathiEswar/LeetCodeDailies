package LeetCodeDaily;

public class ShiftLetter2 {
    class Solution {
        /*
            INFERENCES :
                String s - lowercase , min len 1 ,
                shifts[] - will be inclusive range, dir 1 - forward , 0 - backward
                            the movement is always +1 or -1

            BRUTE FORCE :
                - iterate through shifts
                    - get the query
                    - iterate through the range
                        - change the letters depending ont the direction

                - return the string buffer to string

                SC - O(n)
                TC - O(n + m)

            OPTIMIZED - Line Sweep :
                - use a sweep array to store the prefix precomputations in n+1 array
                where :
                    - when its forward :
                        - left range must be incremented and right + 1 must be decrmented
                    - when its backward :
                        - left must be decremented and right +1 must be incremented
                - iterate through shifts and form the prefix array

                - iterate through the string and apply the needed modification for each letter

                - return the string

                SC - O(n) [ char array ] + O(n) [ prefix array ]


        */
        public String shiftingLetters(String s, int[][] shifts) {
            char[] sarr = s.toCharArray();
            int len = s.length();

            int[] prefix = new int[len+1];

            for(int[] shift : shifts){
                int start = shift[0];
                int end = shift[1];
                int dir = shift[2];

                int value = dir == 1 ? 1 : -1;

                prefix[start] += value;
                prefix[end+1] -= value ;
            }

            int shiftCount = 0 ;
            for(int i = 0 ; i < len ; i++){
                shiftCount = (shiftCount +  prefix[i] ) % 26 ;
                if(shiftCount < 0) shiftCount += 26 ;
                sarr[i] = (char)( 'a' + (sarr[i] - 'a' + shiftCount) % 26 );
            }
            return new String(sarr);
        }
    }
}
