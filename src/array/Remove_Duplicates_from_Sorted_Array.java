package array;

import java.util.HashSet;
import java.util.Set;

/**第26题
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * Created by zhaoshiqiang on 2017/1/13.
 */
//删除数组中重复元素
public class Remove_Duplicates_from_Sorted_Array {

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0 ){
            return 0;
        }
        if (length == 1){
            return 1;
        }
        int index=0;
        for (int i=1; i<length; i++){
            if (nums[index] != nums[i]){
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }

    public static void main(String[] args){
        int[] a = new int[]{1,1,1,2,3,3,5};
        int length = removeDuplicates(a);
        System.out.println(length);
        for (int i=0; i<length; i++){
            System.out.print(a[i]+"  ");
        }
    }
}
