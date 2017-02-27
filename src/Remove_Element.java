/**第27
 * Given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.
 * Created by zhaoshiqiang on 2017/2/22.
 */
//类快速排序
public class Remove_Element {

    public int removeElement(int[] nums, int val) {
        int rear=nums.length;
        int num=0;
        for (int i=0;i<rear; i++){
            if (nums[i]==val){
                num++;
                swap(nums,--rear,i);
                i--;    //交换后的数依然要比较
            }
        }
        return nums.length-num;
    }

    private void swap(int num[], int x, int y){
        int tmp = num[x];
        num[x] = num[y];
        num[y] = tmp;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,2,2,3};
        int n=new Remove_Element().removeElement(nums,3);
        for (int i=0; i<n; i++){
            System.out.println(nums[i]);
        }
    }
}
