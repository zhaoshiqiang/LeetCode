package search;

/**第34题
 * Given an array of integers sorted in ascending order,
 * find the starting and ending position of a given target value.
     Your algorithm's runtime complexity must be in the order of O(log n).
     If the target is not found in the array, return [-1, -1].

     For example,
     Given [5, 7, 7, 8, 8, 10] and target value 8,
     return [3, 4].
 * Created by zhaoshiqiang on 2017/1/28.
 */
//二分查找
/* 二分查找方法
   二分查找经常用来在有序的数列查找某个特定的位置。
   因此，应用二分查找法，这个数列必须包含以下特征：
    存储在数组中
    有序排列
* */
public class Search_for_a_Range {
    public static int[] searchRange(int[] nums, int target) {
        if (nums==null || nums.length==0){
            return new int[]{-1,-1};
        }

        int[] res = new int[]{-1,-1};
        int length = nums.length;
        int low=0,high=length-1;
        int pos = 0;
        /*
        * 第一步，在给定数组中找到该target，记录该位置。这时我们并不关心这个target是边界还是中间值，
        * 我们只需确定，在数组中是能够找到这样一个target值。如果找不到返回{-1，-1}。
        * 为了保证时间复杂度是O(logn), 这里自然而然使用传统二分查找法实现。
        * */
        while (low <= high){
            int mid = (low+high)/2;
            pos=mid;
            //保证每次循环的时候，搜索范围都减小，从而避免出现死循环
            if (nums[mid] < target){
                low = mid+1;
            }else if (nums[mid] > target){
                high = mid-1;
            }else {
                res[0]=mid;
                res[1]=mid;
                break;
            }
        }
        //如果没有找到则直接退出
        if (nums[pos] != target){
            return res;
        }
        /*
        * 第二步，确定该target的右边界。此时我们将对数组从刚才确定的那个target的pos作为起始点，到数组结束，
        * 来确定右边界。同样是使用二分查找法，当新的mid值仍然等于target值时，
        * 我们能确定该mid左半边（到pos）都是等于target，继续在右半边查找。如果新的mid值不等于target值，
        * 我们就知道右边界一定在新mid值的左半边，继续查找。最后新的high指针指向的就是右边界的位置。
        * */
        int newlow = pos+1;
        int newhigh = length-1;
        while (newlow <= newhigh){
            int mid = (newlow+newhigh)/2;
            pos=mid;
            if (nums[mid] == target){
                newlow = mid+1;
            }else {
                newhigh = mid-1;
            }
        }
        //注意这里是newhigh
        res[1]=newhigh;
        /*
        * 第三步，确定该target的左边界。这一步与第二步对称操作，最后新的low指针指向的就是左边界的位置。
        * */
        newhigh=pos-1;
        newlow=0;
        while (newlow <= newhigh){
            int mid = (newlow+newhigh)/2;
            if (nums[mid] == target){
                newhigh = mid-1;
            }else {
                newlow = mid+1;
            }
        }
        //注意这里是newlow
        res[0]=newlow;
        return res;
    }

    public static void main(String[] args){
//        int[] nums = new int[]{2,2};
//        int[] nums = new int[]{5, 7, 7, 9, 9, 10};
        int[] nums = new int[]{1,2,3,3,3,3,4,5,9};
        int[] index =searchRange(nums,3);
        System.out.println(index[0]);
        System.out.println(index[1]);

    }
}
