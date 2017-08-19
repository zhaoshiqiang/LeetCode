/**
 * 第67
 *  Given two binary strings, return their sum (also a binary string).

     For example,
     a = "11"
     b = "1"
     Return "100".
 * Create by zhaoshiqiang on 9:53 2017/8/19
 */
public class Add_Binary {

    public static String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int carry = 0;  //是否进位
        String res = "";
        int maxLen = Math.max(m,n);
        for (int i = 0; i < maxLen; i++) {
            //标记a和b第i位的数字
            int p=0,q=0;

            if (i<m){
                p = a.charAt(m-1-i)-'0';
            }
            if (i<n){
                q = b.charAt(n-1-i)-'0';
            }

            int temp = p + q + carry;
            carry = temp/2;
            //这里是字符串的拼接，注意顺序
            res  = temp%2 + res;
        }
        return carry==0 ? res : 1+res;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010","1011"));
    }
}
