package LeetCodeDaily;

public class ClearDigits {
    class Solution1 {
        public String clearDigits(String s) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                if (Character.isDigit(ch)) {
                    sb = sb.delete(i - 1, i + 1);
                    i -= 2;
                }
            }

            return new String(sb);
        }
    }
}
