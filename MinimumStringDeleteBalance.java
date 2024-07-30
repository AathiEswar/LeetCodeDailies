package LeetCodeDaily;

public class MinimumStringDeleteBalance {
    class Optimize{
        public int minimumDeletions(String s) {
            int aCount = 0 ;
            int bCount = 0 ;

            for(char ch : s.toCharArray()){
                // if the char is b increase count of b
                if(ch == 'b'){
                    bCount++;
                }

                // if the char is a and b already exist then increase count of a and decrease b count;
                else if(bCount > 0){
                    aCount++;
                    bCount--;
                }
            }

            return aCount;
        }
    }
    class Own{
        public int minimumDeletions(String s) {
            int count = 0 ;
            StringBuilder sb = new StringBuilder(s);

            for(int i = 1 ; i < sb.length() ; i++){
                if(sb.charAt(i) == 'a' && sb.charAt(i-1) == 'b'){
                    sb.delete(i-1 , i+1);
                    count++;
                    i-= (i > 1 ? 2 : 1) ;
                }
            }
            return count;

        }
    }
}
