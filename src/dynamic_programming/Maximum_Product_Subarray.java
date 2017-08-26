package dynamic_programming;

/**
 * 第152题
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest product.

     For example, given the array [2,3,-2,4],
     the contiguous subarray [2,3] has the largest product = 6.
 * Created by zhaoshiqiang on 2017/7/17.
 */
//局部最优+全局最优解法
public class Maximum_Product_Subarray {

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        /**
         * 这道题的思路与{@link Maximum_Subarray}类似，
         * 只是这里要考虑到一种特殊情况，即负数和负数相乘：如果前面得到一个较小的负数，和后面一个较大的负数相乘，得到的反而是一个较大的数，
         * 如{2，-3，-7}，所以，我们在处理乘法的时候，除了需要维护一个局部最大值，同时还要维护一个局部最小值
         */
        int global = nums[0];
        int localMax = nums[0];
        int localMin = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            int minCopy = localMin;
            localMin = Math.min(Math.min(localMin * nums[i], nums[i]), localMax * nums[i]);
            localMax = Math.max(Math.max(localMax * nums[i], nums[i]),minCopy * nums[i]);
            global = Math.max(global, localMax);
        }
        return global;
    }

    public static void main(String[] args) {
        int[] num = new int[]{2, -3, -7};
        System.out.println(maxProduct(num));
    }
}
