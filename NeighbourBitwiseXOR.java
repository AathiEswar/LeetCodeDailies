package LeetCodeDaily;

public class NeighbourBitwiseXOR {
    class Solution {
        /*
            INFERENCE :
                - derived only contains 1 and 0
                - return true or false
                - derived is given and we need to find org
                - org[i] ^ org[i+1] = der[i]
        */
        public boolean doesValidArrayExist(int[] derived) {
            int sum = 0 ;

            for( int i = 0 ; i < derived.length  ; i++){
                sum ^= derived[i];
            }

            return sum == 0 ;
        }
    }
}
