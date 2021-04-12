package stack;

import java.util.Stack;

/**
 * 155
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */
public class Min_Stack {

    private Stack<Integer> stack;
    private Stack<Integer> min_stack;
    /** initialize your data structure here. */
    public Min_Stack() {
        this.stack = new Stack<>();
        this.min_stack = new Stack<>();
    }
    // 关键 1：辅助栈的元素空的时候，必须放入新进来的数
    // 关键 2：新来的数小于或者等于辅助栈栈顶元素的时候，才放入（特别注意这里等于要考虑进去）
    public void push(int val) {
        stack.push(val);
        if(min_stack.isEmpty() || min_stack.peek() >= val){
            min_stack.push(val);
        }
    }

    // 关键 3：出栈的时候，辅助栈的栈顶元素等于数据栈的栈顶元素，才出栈，即"出栈保持同步"就可以了
    public void pop() {
        if (stack.pop().equals(min_stack.peek())){
            min_stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min_stack.peek();
    }
}
