package other;

/**
 * 第43
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
     Note:
     The length of both num1 and num2 is < 110.
     Both num1 and num2 contains only digits 0-9.
     Both num1 and num2 does not contain any leading zero.
     You must not use any built-in BigInteger library or convert the inputs to integer directly.

 * Create by zhaoshiqiang on 14:14 2017/8/19
 */
public class Multiply_Strings {

    public static String multiply(String num1, String num2) {
        //这种个位在后面的，不好做，所以干脆先把string reverse了代码就清晰好多，这是一个技巧
        num1 = new StringBuffer(num1).reverse().toString();
        num2 = new StringBuffer(num2).reverse().toString();
        //这个数组最大长度是num1.len + num2.len，比如99 * 99，最大不会超过10000，所以4位就够了。
        int[] d = new int[num1.length() + num2.length()];
        int multiplie1,multiplie2;
        //比如385 * 97, 就是个位=5 * 7，十位=8 * 7 + 5 * 9 ，百位=3 * 7 + 8 * 9 …可以每一位用一个Int表示，存在一个int[]里面。
        for (int i = 0; i < num1.length(); i++) {
            multiplie1 = num1.charAt(i) - '0';
            for(int j=0; j<num2.length(); j++){
                multiplie2 = num2.charAt(j) - '0';
                d[i+j] += multiplie1 * multiplie2;
            }
        }
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for (int i = 0; i < d.length; i++) {
            //这个是低位在前，高位在后，后面需要将其反转，并将首位的0剔除
            sb.append( d[i]%10 );
            carry = d[i]/10;
            if (i < d.length-1){
                d[i+1] += carry;
            }
        }
        //最后结果前面的0要清掉
        String result = sb.reverse().toString().replaceAll("^0*","");
        return "".equals(result) ? "0" : result;
    }

    public static void main(String[] args) {
        System.out.println(multiply("0","0"));
    }
}
