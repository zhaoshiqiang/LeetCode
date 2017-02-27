import java.util.HashSet;
import java.util.Set;

/**第128
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     For example,
     Given [100, 4, 200, 1, 3, 2],
     The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

     Your algorithm should run in O(n) complexity.
 * Created by zhaoshiqiang on 2017/2/14.
 */
//哈希表
public class Longest_Consecutive_Sequence {

    /*
    * 要实现O(n)的时间复杂度，就不能对数组排序。而要降低时间复杂度，一个经典的方案就是空间换时间。
    * 用增加空间复杂度的方法来换取时间复杂度的降低。
    * 所以我们可以先对数组进行一次预处理，生成一份包含数组元素的哈希表。
    * 这样在求解某个数字在不在数组时就可以得到O(1)的时间复杂度。
    * */
    // 遇到不能排序又要复杂度O(n)有序的问题，只能增加空间复杂度，一般都是hash表
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int maxlength=0;
        for (int i=0; i<nums.length; i++){
            if (set.contains(nums[i])){
                int value = nums[i];
                int addnum=1;
                set.remove(value);
                while (set.contains(++value)){
                    addnum++;
                    set.remove(value);
                }
                value = nums[i];
                int minus=0;
                while (set.contains(--value)){
                    minus++;
                    set.remove(value);
                }
                if (maxlength < minus+addnum){
                    maxlength=minus+addnum;
                }
            }
        }
        return maxlength;
    }
}
