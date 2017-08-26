package dynamic_programming;

/**
 * 第55题
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

     Each element in the array represents your maximum jump length at that position.

     Determine if you are able to reach the last index.

     For example:
     A = [2,3,1,1,4], return true.

     A = [3,2,1,0,4], return false.
 * Created by zhaoshiqiang on 2017/7/16.
 */
//动态规划 “局部最优和全局最优解法”
public class Jump_Game {

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        /**
        * 所用到的方法和{@link Maximum_Subarray}中介绍的套路一样，用“局部最优和全局最优解法”。
        * 我们维护一个到目前为止能跳到的最远距离，以及从当前一步出发能跳到的最远距离。
        * 局部最优解表达式为local=A[i]+i：因为local已经在i的位置上，而且num[i]>=0，则其最远距离是当前距离+能跳的距离。
        * 全局最优解表达式为global=Math.max(global, local)
        * 有了当前一步的局部最优，那么全局最优就是当前的局部最优或者还是原来的全局最优
        * （所有情况都会被涵盖进来，因为最优的解如果不包含当前元素，那么前面会被维护在全局最优里面，如果包含当前元素，那么就是这个局部最优）
        * */
        int local = nums[0];
        int global = nums[0];
        //这里的i限制在最远到达的距离和数组长度内
        for (int i=1; i<nums.length && i <= global ; i++){
            local = nums[i] + i;
            global = Math.max(global,local);
        }
        if (global < nums.length-1){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{3,2,1,0,4};
        System.out.println(canJump(num));
    }
}
