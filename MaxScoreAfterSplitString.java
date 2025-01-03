package LeetCodeDaily;

public class MaxScoreAfterSplitString {
    class Solution {
        public int maxScore(String s) {
            int len = s.length();

            int countOne = 0;
            int countZero = 0;
            int max = 0;

            for(int i = len-1 ;i >= 0 ; i-- ){
                if(s.charAt(i) == '1'){
                    countOne++;
                }
            }

            for(int i = 0 ; i< len-1 ;i++){
                if(s.charAt(i) == '0'){
                    countZero++ ;
                }
                else{
                    countOne--;
                }
                max = Math.max(max , countZero + countOne );
            }
            return max;
        }
    }
}
