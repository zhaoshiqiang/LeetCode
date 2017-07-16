/**
 * 第45题
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

     Each element in the array represents your maximum jump length at that position.

     Your goal is to reach the last index in the minimum number of jumps.

     For example:
     Given array A = [2,3,1,1,4]

     The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

     Note:
     You can assume that you can always reach the last index.
 * Created by zhaoshiqiang on 2017/7/16.
 */
//动态规划 “局部最优和全局最优解法”
public class Jump_GameII {
    public static int jump(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        /**
         * 这道题是{@link Jump_Game}的扩展，区别是这道题不仅要看能不能到达终点，而且要求到达终点的最少步数。
         * 其实思路和Jump Game还是类似的，只是原来的全局最优现在要分成step步最优和step-1步最优（假设当前步数是step）。
         * 当走到超过step-1步最远的位置时，说明在step-1内不能到达当前这一步，我们就更新步数，step++。
         */
        int lastReach = 0;
        int global = 0;
        int local = 0;
        int step = 0;
        for(int i=0;i<=global&&i<nums.length;i++)
        {
            if(i>lastReach)
            {
                step++;
                lastReach = global;
            }
            local = nums[i] + i;
            global = Math.max(global,local);
        }
        if(global<nums.length-1)
            return 0;
        return step;
    }

    public static void main(String[] args) {
        int[] num = new int[]{2,3,1,1,4};
        System.out.println(jump(num));
    }
}
