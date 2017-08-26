package other;

import java.util.Arrays;

/**第16
 * Given an array S of n integers,find three integers in S such that the sum is closest to a given number,target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

     For example, given array S = {-1 2 1 -4}, and target = 1.

     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Created by zhaoshiqiang on 2017/2/6.
 */
//求和问题
public class Sum3_Closest {

    public static int threeSumClosest(int[] nums, int target) {
        int result=0;
        int min=Integer.MAX_VALUE;
        if (nums == null || nums.length < 3)
            return result;
        Arrays.sort(nums);
        int length=nums.length;
        for (int i=0; i<length; i++){
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int l=i+1,r=length-1;
            while (l<r){
                int sum=nums[l]+nums[r]+nums[i];
                if (sum > target){
                    if (sum-target < min){
                        min=sum-target;
                        result=sum;
                    }
                    r--;
                }else if (sum < target){
                    if (target-sum < min){
                        min=target-sum;
                        result=sum;
                    }
                    l++;
                }else {
                    return target;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
//        int[] nums = new int[]{0,0,0};
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums,1));
    }
}
