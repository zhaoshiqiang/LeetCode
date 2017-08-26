package sort;

/**第41题
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 * Created by zhaoshiqiang on 2017/1/17.
 */
//桶排序
public class First_Missing_Positive {
    public static int firstMissingPositive(int[] nums) {
        /*
        * 由于只关心正数，而且要求的数必然小于数组长度，可以利用桶排序的思想
        * */
        for (int i=0;i<nums.length;i++){
            while (nums[i] != i+1){
                //负数，大于等于数组长度的数，nums[i]==nums[nums[i]-1]数都直接跳过，这些不是我们所关心的
                if (nums[i]<=0 || nums[i]>=nums.length || nums[i] == nums[nums[i]-1]){
                    break;
                }
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i]=temp;
            }
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args){
        int[] nums =new  int[]{1,1};
        System.out.println(firstMissingPositive(nums));
    }
}
