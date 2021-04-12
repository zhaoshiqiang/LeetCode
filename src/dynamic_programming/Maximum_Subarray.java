package dynamic_programming;

import dynamic_programming.Jump_Game;

/**
 *  第53题
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

    For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
    the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * Created by zhaoshiqiang on 2017/7/16.
 */
//非常经典的动态规划题目，“局部最优+全局最优解法”，数组中连续最大和
public class Maximum_Subarray {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        /**
        * 基本思路是这样的：
        * 在每一步，我们维护两个变量，一个是全局最优，就是到当前元素为止最优的解；一个是局部最优，就是必须包含当前元素的最优的解。
        * 接下来说说动态规划的递推式（这是动态规划最重要的步骤，递归式出来了，基本上代码框架也就出来了）。
        * 假设我们已知第i步的global[i]（全局最优）和local[i]（局部最优），
        * 那么第i+1步的local[i]表达式是：local[i+1]=Math.max(A[i+1], local[i]+A[i+1])，
        * 就是局部最优是一定要包含当前元素，local[i+1]就是在上一步的局部最优local[i]+当前元素A[i+1]和A[i+1]中作选择
         * 但是如果local[i]是负的，那么加上他就不如不需要的，所以不然就是直接用A[i]；
        * 那么第i+1步的global[i]表达式是global[i+1]=Math(local[i+1],global[i])，
        * 有了当前一步的局部最优，那么全局最优就是当前的局部最优或者还是原来的全局最优
        * （所有情况都会被涵盖进来，因为最优的解如果不包含当前元素，那么前面会被维护在全局最优里面，如果包含当前元素，那么就是这个局部最优）。
        * 该思路在{@link Jump_Game}
        * */
        /*
        * 接下来我们分析一下复杂度，时间上只需要扫描一次数组，所以时间复杂度是O(n)。
        * 空间上我们可以看出表达式中只需要用到上一步local[i]和global[i]就可以得到下一步的结果，
        * 所以我们在实现中可以用一个变量来迭代这个结果，不需要是一个数组
        * */
        int global = nums[0];
        int local = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            local = Math.max(local + nums[i], nums[i]);
            global = Math.max(global, local);
        }
        return global;
    }

    public static void main(String[] args) {
        int[] num = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(num));
    }
}
