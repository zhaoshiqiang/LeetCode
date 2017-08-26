package other;

import com.sun.org.apache.bcel.internal.generic.IINC;

/** 第31题
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 * Created by zhaoshiqiang on 2016/12/31.
 */
public class Next_permutation {
    //eg: nums = 6 5 4 8 7 5 1
    public static void nextPermutation(int[] nums) {
        int length=nums.length;
        if (length == 0 || length == 1){
            return;
        }
        int index = length-1;
        while (index >0){
            //保证index后面的数字都是从大到小排列
            if (nums[index] > nums[index-1]){
                break;
            }
            index--;
        }
        //如果nums已经从大到小排好，直接从小到大排列即可
        if (index == 0){
            int stop = length/2;
            for (int i=0; i<stop; i++){
                int j = length-i-1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }else {
            //这里index标记为8的下标，要记录4，故要减1
            index--;
            int second = -1;
            //找到比4大但在这些大数里面最小的值，然后将其两者调换
            for (int i=length-1; i>index;i--){
                if (nums[i] > nums[index]){
                    second = i;
                    break;
                }
            }
            //调换
            int t = nums[index];
            nums[index] = nums[second];
            nums[second] = t;
            //将4后面的数字从小到大排列
            int stop = (index+length)/2-index;
            for (int i=1;i<= stop;i++){
                int j = length-i;
                int temp = nums[i+index];
                nums[i+index] = nums[j];
                nums[j] = temp;
            }
        }

    }

    public static void main(String[] args){
        int[] a =new int[]{6,5,4,8,7,5,1};
        nextPermutation(a);
        for (int i=0; i<a.length;i++){
            System.out.print(a[i]+ "   ");
        }

    }
}
