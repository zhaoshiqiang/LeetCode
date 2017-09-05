package stack;

import java.util.Stack;

/**第150题
 *Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

     Some examples:
     ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

 * Created by zhaoshiqiang on 2017/1/19.
 */
//栈
public class Evaluate_Reverse_Polish_Notation {

    public static int evalRPN(String[] tokens) {
        if (tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int num1,num2;
        for (int i=0; i<tokens.length; i++){
            switch (tokens[i]){
                case "+" : num1=stack.pop(); num2=stack.pop();stack.push(num1+num2);break;
                case "-" : num1=stack.pop(); num2=stack.pop();stack.push(num2-num1);break;
                case "*" : num1=stack.pop(); num2=stack.pop();stack.push(num1*num2);break;
                case "/" : num1=stack.pop(); num2=stack.pop();stack.push(num2/num1);break;
                default:stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args){
        String[] strings = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(strings));
    }
}
