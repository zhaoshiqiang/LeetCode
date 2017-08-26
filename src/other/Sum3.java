package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**第15
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.

     For example, given array S = [-1, 0, 1, 2, -1, -4],
     A solution set is:
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]
 * Created by zhaoshiqiang on 2017/2/4.
 */
//求和问题，参考http://blog.csdn.net/nanjunxiao/article/details/12524405
public class Sum3 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return result;

        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len-2; i++) {
            //跳过重复的
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            find(nums, i+1, len-1, nums[i],result); //寻找两个数与num[i]的和为0
        }

        return result;
    }

    private static void find(int[] nums,int begin,int end,int value,List<List<Integer>> result){
        int l=begin,r=end;
        while (l<r){
            if (nums[l]+nums[r]+value == 0){
                List<Integer> list = new ArrayList<>();
                list.add(value);
                list.add(nums[l]);
                list.add(nums[r]);
                //放入结果集
                result.add(list);
                //跳过重复的
                while (l<r && nums[l]==nums[l+1]){
                    l++;
                }
                while (l<r && nums[r]==nums[r-1]){
                    r--;
                }
                l++;
                r--;
            }else if (nums[l]+nums[r]+value > 0){
                r--;
            }else if (nums[l]+nums[r]+value < 0){
                l++;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists){
            System.out.println();
            for (Integer val : list){
                System.out.print(val + "   ");
            }
        }
    }

}
