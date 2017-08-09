/**
 * 《剑指offer》面试题14 调整数组顺序是奇数位于偶数前面
 * Created by zhaoshiqiang on 2017/8/8.
 */
public class Offer_Problem14 {

    public static void order(int[] array){
        if (array == null || array.length == 0){
            return;
        }
        int position = 0;
        for (int i = 0; i < array.length; i++) {
            if (!isEven(array[i])){
                int temp = array[position];
                array[position] = array[i];
                array[i] = temp;

                position++;
            }
        }
    }
    private static boolean isEven(int n){
        return n%2 == 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        order(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ",nums[i]);
        }
    }
}
