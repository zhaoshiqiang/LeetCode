import java.util.List;

/**
 * 第125题 Valid Palindrome
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

     For example,
     "A man, a plan, a canal: Panama" is a palindrome.
     "race a car" is not a palindrome.

     Note:
     Have you consider that the string might be empty? This is a good question to ask during an interview.

     For the purpose of this problem, we define empty string as valid palindrome.
 * Created by zhaoshiqiang on 2017/7/16.
 */
public class Valid_Palindrome {

    public static boolean isPalindrome(String s) {
        if (s == null){
            return false;
        }
        //先用正则表达式去掉无效字符，再将其全部转换成小写，方便后续比较
        s = s.replaceAll("[^0-9a-zA-Z]","").toLowerCase();
        if ("".equals(s)){
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            char charLeft = s.charAt(left);
            char charRight = s.charAt(right);
            if (charLeft != charRight){
                return false;
            }else {
                left ++;
                right --;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
