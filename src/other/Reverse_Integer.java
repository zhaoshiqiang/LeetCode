package other;

/**
 * 第7
 * Reverse digits of an integer.

     Example1: x = 123, return 321
     Example2: x = -123, return -321
 * @Author: zhaoshiqiang
 * @Date Create in 9:11 2017/8/19
 */
public class Reverse_Integer {

    /**
     * 通过对数字模十取余得到它的最低位。其实本题考查的是整数相加的溢出处理，检查溢出有这么几种办法：

         1、两个正数数相加得到负数，或者两个负数相加得到正数，但某些编译器溢出或优化的方式不一样
         2、于正数，如果最大整数减去一个数小于另一个数，或者对于负数，最小整数减去一个数大于另一个数，则溢出。这是用减法来避免加法的溢出。
         3、使用long来保存可能溢出的结果，再与最大/最小整数相比较
     * @param x
     * @return
     */
    public static int reverse(int x){
        long result = 0;
        int temp = Math.abs(x);
        while (temp > 0){
            result = result*10 + temp%10;
            if (result > Integer.MAX_VALUE){
                return 0;
            }
            temp/=10;
        }
        return (int) (x>=0 ? result: -result);
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
