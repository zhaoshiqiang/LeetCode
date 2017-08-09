import java.util.Stack;

/**
 * 《剑指offer》栈的压入，弹出序列
 * Created by zhaoshq on 2017/8/9.
 */
public class Offer_Problem22 {

    public static boolean isPopOrder(int [] pushA,int [] popA){
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        for (int i = 0; i < popA.length; i++) {

            while (stack.isEmpty() || stack.peek() != popA[i]){
                //pushA已经全部入栈，但依然没有匹配到popA[i]，则说明不是弹出序列
                if (start == pushA.length){
                    return false;
                }

                stack.push(pushA[start++]);
            }

            //将匹配到popA[i]弹出，开始匹配popA中的下一个
            stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
//        int[] nums2 = {4,3,5,1,2};
        int[] nums2 = {6,4, 3, 5, 2, 1 };
        System.out.println(isPopOrder(nums1,nums2));
    }
}
