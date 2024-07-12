package LeetCodeDaily;

import java.util.Stack;

public class MaximumScoreFromRemoving {
    class Solution {
        public int maximumGain(String s, int x, int y) {

            int totalCost = 0;
            int maxCost = Math.max(x, y);
            int minCost = Math.min(x, y);

            char firstChar = x > y ? 'a' : 'b';
            char secondChar = x > y ? 'b' : 'a';

            Stack<Character> stack = new Stack<>();

            StringBuilder temp = new StringBuilder(s);

            for(int i = 0;i < temp.length();){

                char ch = temp.charAt(i);

                if(!stack.isEmpty() && stack.peek() == firstChar && ch == secondChar){
                    totalCost += maxCost;
                    stack.pop();
                    temp.replace(i - 1, i + 1, "");
                    i--;
                    continue;
                }

                stack.push(ch);

                i++;

            }

            stack.clear();

            for(int i = 0;i < temp.length();){

                char ch = temp.charAt(i);

                if(!stack.isEmpty() && stack.peek() == secondChar && ch == firstChar){
                    totalCost += minCost;
                    stack.pop();
                    temp.replace(i - 1, i + 1, "");
                    i--;
                    continue;
                }

                stack.push(ch);

                i++;

            }

            return totalCost;

        }
    }
}
