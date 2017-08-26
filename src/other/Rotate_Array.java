package other;

/**
 * 第189
 * Rotate an array of n elements to the right by k steps.

     For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

     Note:
     Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

     [show hint]

     Related problem: Reverse Words in a String II
 * Created by zhaoshiqiang on 2017/8/8.
 */
public class Rotate_Array {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        //注意反转的顺序
        reverse(nums,nums.length - k,nums.length - 1);
        reverse(nums,0,nums.length - k - 1);
        reverse(nums,0,nums.length - 1 );
    }

    private void reverse(int[] nums, int from, int to){
        while (from < to){
            int temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;

            from ++ ;
            to --;
        }
    }
}
