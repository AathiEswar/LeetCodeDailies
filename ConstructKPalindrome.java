package LeetCodeDaily;

public class ConstructKPalindrome {
    class Solution {
        /*
            INFERENCES :
                All the letters must be used to form the group of palindrome

                if k == 1 ? return the string itself if its a palindrome
                if k == len of string ? return len ?
                if k ? len of s ? false

                All letters must be used so there must be atleast two letters for each letter
                    - if even  len then all the letters must have even pairs
                    - if odd len except one letter every other letter must have even pairs

                Will need to find frq of s in order to proceed with the sum ?
                if the odd pairs is <= k then true or else false ?

        */
        public boolean canConstruct(String s, int k) {
            int len = s.length();

            if(len == k){
                return true;
            }
            if(len < k){
                return false;
            }

            int bitMask = 0;

            for(char ch : s.toCharArray()){
                bitMask = bitMask ^ ( 1 << (ch - 'a'));
            }

            bitMask = Integer.bitCount(bitMask);
            return bitMask <= k;
            // TC - O(n)
            // SC - O(1)
        }
    }
}
