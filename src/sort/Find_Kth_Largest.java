package sort;

/**
 * 第215
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class Find_Kth_Largest {

    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int p = partition(nums,start,end);
            if (p == k-1){
                return nums[p];
            }else if (p >= k-1){
                end = p-1;
            }else {
                start = p+1;
            }
        }
        return 0;
    }

    public int partition(int[] nums, int start, int end){
        int flag = nums[end];
        int index = start;

        for (int i = start; i < end; i++) {
            if (nums[i] > flag){
                swap(nums, index++, i);
            }
        }
        swap(nums, index, end);
        return index;
    }

    public void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Find_Kth_Largest().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
