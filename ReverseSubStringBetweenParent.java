package LeetCodeDaily;

import java.util.Stack;

public class ReverseSubStringBetweenParent {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){
            char chr = s.charAt(i);
            //System.out.println(sb.toString());
            if(chr == '(' ){
                stack.push(sb.length());
                //System.out.println(i);
            }
            else if(chr == ')'){
                int start = stack.pop();
                //System.out.println(i + " " + start + " " + sb.length() );
                reverse(sb, start , sb.length()-1);
            }
            else{
                sb.append(chr);
            }
        }

        return sb.toString();
    }
    public void reverse(StringBuilder sb , int start , int end){

        while(start < end){
            char ch = sb.charAt(start);
            sb.setCharAt(start , sb.charAt(end));
            sb.setCharAt(end , ch);

            start++;
            end--;
        }
    }
}
