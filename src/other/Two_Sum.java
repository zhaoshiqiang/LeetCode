package other;

import java.util.HashMap;
import java.util.Map;

/**第1题
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

     You may assume that each input would have exactly one solution.

     Example:
     Given nums = [2, 7, 11, 15], target = 9,

     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].
     UPDATE (2016/2/13):
     The return format had been changed to zero-based indices. Please read the above updated description carefully.

     Subscribe to see which companies asked this question
 * Created by zhaoshiqiang on 2017/1/17.
 */
//哈希表
public class Two_Sum {

    /*
    * 第一个思路，遍历数组中的某一个数，对于每个数再一次遍历数组中的所有数，找到满足条件的两个数。这个算法的时间复杂度为O(n2)，空间复杂度为O(1)。
    * */
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        if (nums==null || length==1){
            return null;
        }
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<length ; i++){
            map.put(nums[i],i);
        }
        for (int i=0; i<length ; i++){
            for (int j=0; j<length ; j++){
                if (i == j)
                    break;
                if (nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }
    /*
    * 构建hash表，第一次遍历nums数组，以nums[i]为键，i为值构建hash表
    * 第二次遍历，查询nums[i]和target-nums[i]是否在hash表中，每次查询的时间复杂度为O(1)，总的时间复杂度为O(n)
    * */
    public static int[] twoSumII(int[] nums, int target) {
        int length = nums.length;
        if (nums==null || length==1){
            return null;
        }
        int[] result = new int[2];

        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<length ; i++){
            map.put(nums[i],i);
        }
        for (int i=0; i<length; i++){
            int residue = target-nums[i];
            Integer value = map.get(residue);
            if ( value != null && value!= i){
                result[0]=i;
                result[1]=value;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,2,4};
        int[] result = twoSumII(nums, 6);
        System.out.println(result[0]);
        System.out.println(result[1]);

    }
}
