package stack;

import java.util.Stack;

/**
 * 第678
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 *
 * 输入: "()"
 * 输出: True
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 *
 * 输入: "(*))"
 * 输出: True
 *
 */
public class CheckValidString {
    /**
     * 括号匹配问题的经典解法
     * 栈存放的是索引
     * 一栈存左括号，一栈存星号
     * 遍历过程中，同时判断是否有足够的右括号使他们出栈
     *      优先抵消左括号（贪心思想)
     * 两栈同时出栈并判断，要求所有左括号，都有 其右边索引的星号 能使其抵消
     * 左括号不能还有富余
     *
     */
    public boolean checkValidString(String s) {
        //存的是符号的下标
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c=='('){
                left.push(i);
            }else if (c == '*'){
                star.push(i);
            }else {
                if (!left.isEmpty()){
                    left.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else {
                    return false;
                }
            }
        }
        // 两栈同时出栈并判断，要求所有左括号，都有 其右边索引的星号 能使其抵消
        while (!left.isEmpty() && !star.isEmpty()){
            if (left.pop() > star.pop()){
                return false;
            }
        }
        //左括号不能还有富余
        return left.isEmpty();
    }
}
