/**
 * 第66
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

     You may assume the integer do not contain any leading zero, except the number 0 itself.

     The digits are stored such that the most significant digit is at the head of the list.
 * Create by zhaoshiqiang on 9:41 2017/8/19
 */
public class Plus_One {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            //当前位加1
            digits[i] = digits[i]+1;
            if (digits[i] == 10){
                //如果需要进位
                digits[i] = 0;
            }else {
                //如果不需要进位，则计算成功
                return digits;
            }
        }
        //99999+1的情况
        int[] newdigit = new int[digits.length+1];
        newdigit[0]=1;
        for (int i = 0; i < digits.length; i++) {
            newdigit[i+1] = digits[i];
        }
        return newdigit;
    }
}
