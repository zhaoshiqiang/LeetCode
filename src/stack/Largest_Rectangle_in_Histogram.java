package stack;

import java.util.Stack;

/**第84题
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 The largest rectangle is shown in the shaded area, which has area = 10 unit.
 For example,
 Given heights = [2,1,5,6,2,3],
 return 10.
 * Created by zhaoshiqiang on 2017/1/23.
 */
//栈
public class Largest_Rectangle_in_Histogram {
    public static int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if (heights.length == 0){
            return 0;
        }
        //栈中存的不是高度，而是copy的索引，这样做的好处是不会影响宽度的计算，索引值相减 = 宽度。
        Stack<Integer> stack = new Stack<>();
        int max=0;
        int[] copy =new int[length+1];
        for (int i=0; i<length ; i++){
            copy[i]=heights[i];
        }
        //在height尾部添加一个0，也就是一个高度为0的立柱。作用是在最后也能凑成“波峰图”。
        copy[length]=0;
        int leftarea=0;
        int rightarea=0;
        for (int i=0; i<=length ; i++){
            //遍历时如果copy[i] 大于stack.top()，进栈。反之，出栈直到栈顶元素小于copy[i]。
            /*
            * 由于出栈的这些元素高度都是递增的，我们可以求出这些立柱中所围成的最大矩形。
            * 更妙的是，由于这些被弹出的立柱处于“波峰”之上(比如弹出i 到 i+k，
            * 那么所有这些立柱的高度都高于 i-1和 i+k+1的高度)，
            * 因此，如果我们使用之前所提的“左右延伸找立柱”的思路解，
            * 以这些立柱的高度作为整个矩形的高度时，左右延伸出的矩形所包含的立柱不会超出这段“波峰”，
            * 因为波峰外的立柱高度都比他们低。“波峰图”其实就是求解最大矩形的“孤岛”，它不会干扰到外部。
            * */
            while ( !stack.isEmpty() && copy[stack.peek()]>copy[i]){
                int tmp=stack.pop();
                leftarea=(stack.isEmpty() ? tmp+1 : tmp-stack.peek())*copy[tmp];
                rightarea=(i-tmp-1)*copy[tmp];
                if (leftarea+rightarea > max){
                    max=leftarea+rightarea;
                }
            }
            //由于比copy[i]大的元素都出完了，copy[i]又比栈顶元素大了，因此再次进栈。
            // 如此往复，直到遍历到最后那个高度为0的柱，触发最后的弹出以及最后一次面积的计算，此后stack为空。
            stack.push(i);
        }
        //返回最大值
        return max;
    }

    public static int largestRectangleAreaII(int[] heights) {
        int length = heights.length;
        if (heights.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max=0;
        int[] copy =new int[length+1];
        for (int i=0; i<length ; i++){
            copy[i]=heights[i];
        }
        copy[length]=0;
        int area=0;
        for (int i=0; i<=length ; i++){
            if (stack.isEmpty() || copy[stack.peek()] <= copy[i]){
                stack.push(i);
            }else {
                int tmp=stack.pop();
                area=copy[tmp]*(stack.empty() ? i : i-stack.peek()-1);
                if (area > max){
                    max=area;
                }
                i--;
            }
        }
        return max;
    }

    public static int largestRectangleAreaIII(int[] heights){
        int length = heights.length;
        if (length == 0){
            return 0;
        }
        int max=0;
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        int[] copy=new int[length+1];
        for (int i=0; i<length ; i++){
            copy[i]=heights[i];
        }
        copy[length]=0;
        for (int i=0; i<=length; i++){
            while (!stack.isEmpty() && copy[i]<copy[stack.peek()]){
                int tmp = stack.pop();
                //注意这里面积的计算和I中的对比
                area=copy[tmp]*(stack.isEmpty() ? i : i-stack.peek()-1);
                if (area > max){
                    max=area;
                }
            }
            stack.push(i);
        }
        return max;
    }
    public static void main(String[] args){
        int[] a =new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleAreaIII(a));

    }
}
