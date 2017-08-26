package stack;

import java.util.Stack;

/**第20题
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

     The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * Created by zhaoshiqiang on 2017/1/26.
 */
public class Valid_Parentheses {
    public static boolean isValid(String s) {
        if (s == null){
            return false;
        }
        int length = s.length();
        char[] chars = s.toCharArray();
        char c;
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<length; i++){
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                stack.push(chars[i]);
            }else if (stack.isEmpty()){
                return false;
            }else if (chars[i]==')'){
                c = stack.pop();
                if (c!='(')
                    return false;
            } else if (chars[i]==']'){
                c = stack.pop();
                if (c!='[')
                    return false;
            }
            else if (chars[i]=='}'){
                c = stack.pop();
                if (c!='{')
                    return false;
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        System.out.println(isValid("()[]{}"));

    }
}
