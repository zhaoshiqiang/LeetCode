package search;

/**第35
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.

     You may assume no duplicates in the array.
     Here are few examples.
     [1,3,5,6], 5 → 2
     [1,3,5,6], 2 → 1
     [1,3,5,6], 7 → 4
     [1,3,5,6], 0 → 0
 * Created by zhaoshiqiang on 2017/1/28.
 */
public class Search_Insert_Position {

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int index=0;
        for (int i=0; i<length; i++){
            if (nums[i]>= target){
                index=i;
                return index;
            }
        }
        return length;
    }

    public static int searchInsertII(int[] nums, int target){
        int mid;
        int l=0;
        int h = nums.length-1;

        while (l <= h){
            mid = (l + h)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                l = mid + 1;
            }else {
                h = mid-1;
            }
        }
        return l;
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsertII(nums,2));

    }

}
