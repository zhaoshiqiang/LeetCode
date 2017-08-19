/**
 * 第9
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * @Author: zhaoshiqiang
 * @Date Create in 8:59 2017/8/19
 */
public class Palindrome_Number {

    /**
     * 复制将给定int从低位往高位开始，复制为另外一个高位至低位，得到一个给定值的反序。再比较两者是否相等。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int ret=0;
        int t=x;
        //负数无回文数
        if (x<0){
            return false;
        }
        while (t>0){    //判断是否将x的位数取完
            ret = ret * 10 + t%10;  //将t的最后一位拼接在ret后面
            t = t/10;

        }
        return ret == x;    //比较两个数是否相等
    }
}
