package Offer_Problem;

import java.util.Stack;

/**
 * 《剑指offer》面试题21 包含min函数的栈
 * Created by zhaoshiqiang on 2017/8/8.
 */
public class Offer_Problem21 {
    private Stack<Integer> minStack = new Stack<Integer>();
    private Stack<Integer> dataStack = new Stack<Integer>();

    public void push(Integer item){
        dataStack.push(item);
        if (minStack.size() == 0 || minStack.peek() > item){
            minStack.push(item);
        }else {
            minStack.push(minStack.peek());
        }
    }

    public Integer pop(){
        if (minStack.size() == 0 || dataStack.size() == 0){
            return null;
        }
        minStack.pop();
        return dataStack.pop();
    }

    public Integer min(){
        if (minStack.size() == 0){
            return null;
        }
        return minStack.pop();
    }
}
