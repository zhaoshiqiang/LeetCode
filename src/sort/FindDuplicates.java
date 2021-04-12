package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 第442
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 *
 */
public class FindDuplicates {
    /**
     * 不使用额外空间，在原数组上对值进行标记。我们用 nums[nums[i]-1] 来判断 nums[i] 是否出现过
     * （减1是为了防止下标越界，数组下标从0开始，而数值从1开始），
     * 如果 nums[i] 第一次出现则将 nums[nums[i]-1] * -1，
     * 使用这样的方法就可以实现在原数组上对值进行标记。（注意下标越界的问题）
     *
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = Math.abs(nums[i]) - 1;
            // 如果 nums[tmp] < 0 则表示该数已出现过进行记录
            if (nums[tmp] > 0) {
                nums[tmp] = -nums[tmp];
            } else {
                list.add(tmp + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicates().findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }

}
