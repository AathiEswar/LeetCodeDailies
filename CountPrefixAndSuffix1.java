package LeetCodeDaily;

public class CountPrefixAndSuffix1 {
    class Solution {
        public int countPrefixSuffixPairs(String[] words) {
            int count = 0;

            for(int i = 0 ; i < words.length-1 ; i++ ){
                String left = words[i];

                for(int j = i+1 ; j < words.length ; j++ ){
                    String right = words[j];

                    if( left.length() <= right.length()){
                        if(isPrefixAndSuffix( left , right )){
                            count = count + 1 ;
                        }
                    }
                }
            }
            return count;
        }

        public boolean isPrefixAndSuffix(String str1 , String str2){
            int len1 = str1.length();
            int len2 = str2.length();

            for(int i = 0 ; i< len1 ; i++){
                char str1St = str1.charAt(i);
                char str2St = str2.charAt(i);

                char str1End = str1.charAt( len1 - i - 1);
                char str2End = str2.charAt( len2 - i - 1);

                if( str1St != str2St || str1End != str2End){
                    return false;
                }
            }
            return true;
        }
    }
}
