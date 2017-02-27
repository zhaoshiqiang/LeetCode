/**第136
 * Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Created by zhaoshiqiang on 2017/2/25.
 */
public class Single_Number {
    //直接排序或对比，时间复杂度一定在nlogn以上。
    // 利用Hash表或者Bitmap可以满足时间复杂度但是空间复杂度不能满足。
    // O(n)时间类能采用的办法只有异或。
    //因为A XOR A = 0，且XOR运算是可交换的，于是，对于实例{2,1,4,5,2,4,1}就会有这样的结果：
    // (2^1^4^5^2^4^1) => ((2^2)^(1^1)^(4^4)^(5)) => (0^0^0^5) => 5
    public int singleNumber(int[] nums) {
        int i=nums.length;
        while (--i != 0)
            nums[i-1]^=nums[i];
        return nums[0];
    }
}
