package array;

/**第80题
 * Follow up for "Remove Duplicates":
     What if duplicates are allowed at most twice?

     For example,
     Given sorted array nums = [1,1,1,2,2,3],

     Your function should return length = 5,
     with the first five elements of nums being 1, 1, 2, 2 and 3.
     It doesn't matter what you leave beyond the new length.
 * Created by zhaoshiqiang on 2017/1/13.
 */
//数组 也可以用hash表，删除数组中次数超过2的部分
public class Remove_Duplicates_from_Sorted_ArrayII {
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0 ){
            return 0;
        }
        if (length == 1){
            return 1;
        }
        int index=0;
        int same=1;
        for (int i=1; i<length; i++){
            if (nums[index] != nums[i]){
                nums[++index] = nums[i];
                same=1;
            }else if (nums[index] == nums[i] && same<2){
                same++;
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }

    public static void main(String[] args){
        int[] a = new int[]{1,1,1,2,2,2,2,3,3,5};
        int length = removeDuplicates(a);
        System.out.println(length);
        for (int i=0; i<length; i++){
            System.out.print(a[i]+"  ");
        }
    }
}
