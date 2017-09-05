package stack;

import java.util.Stack;

/**32题
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.

     For "(()", the longest valid parentheses substring is "()", which has length = 2.
     Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * Created by zhaoshiqiang on 2017/1/26.
 */
//栈
public class Longest_Valid_Parentheses {
    //思考这个题目比较容易进入误区。其实我们只需要考虑每个右括号匹配最近的最括号即可。最后找出连续的匹配结果。
    public static int longestValidParentheses(String s) {
        if (s.length() < 2){
            return 0;
        }else {
            char[] chars = s.toCharArray();
            int length = chars.length;
            int max=0;
            int count=0;
            boolean[] flags= new boolean[length];
            Stack<Integer> stack = new Stack<>();
            for (int i=0; i<length; i++){
                if (chars[i] == '('){
                    stack.push(i);
                }else {
                    if (!stack.isEmpty()){
                        int index = stack.pop();
                        if (chars[index] == '('){
                            flags[index]=true;
                            flags[i]=true;
                        }
                    }else {
                        flags[i]=false;
                    }
                }
            }
            for (int i=0; i<length; i++){
                if (flags[i]){
                    count++;
                }else {
                    if (max<count){
                        max=count;
                    }
                    count=0;
                }
            }
            if (max<count){
                max=count;
            }
            return max;
        }
    }

    public static void main(String[] args){

        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses(")()())"));

    }
}
