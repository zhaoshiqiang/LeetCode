/**第29
 * Divide two integers without using multiplication, division and mod operator.
    If it is overflow, return MAX_INT.
 * Created by zhaoshiqiang on 2017/2/14.
 */
//用移位操作实现除法
public class Divide_Two_Integers {

    public static int divide(int dividend, int divisor) {
        int sign=1;
        if (dividend<0) sign=-sign;
        if (divisor<0) sign=-sign;
        long temp = Math.abs((long)dividend);
        long temp2 = Math.abs((long)divisor);
        long c=1;
        //这个方法很巧妙
        while (temp > temp2){
            temp2=temp2<<1;
            c=c<<1;
        }
        long result=0;
        long flag = Math.abs((long)divisor);
        while (temp >= flag){
            while (temp>=temp2){
                temp=temp-temp2;
                result+=c;
            }
            temp2=temp2>>1;
            c=c>>1;
        }

        if (sign>0){
            //int的最大值是2147483647
            if (result>Integer.MAX_VALUE)
                result=Integer.MAX_VALUE;
            return (int) result;
        } else{
            //int的最小值是-2147483648，所以-Integer.MIN_VALUE还是-2147483648，这里需要把result取反来比较
            if (-result < Integer.MIN_VALUE){
                result=Integer.MIN_VALUE;
                return (int) result;
            }
            return (int) -result;
        }
    }

    public static void main(String[] args){
        System.out.println(divide(-1, 1));
        System.out.println(divide(-2147483648, -1));

    }
}
