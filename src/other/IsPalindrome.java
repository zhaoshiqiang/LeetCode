package other;

/**
 * 第125
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s==null || "".equals(s)){
            return true;
        }

        s = s.toLowerCase();
        int start=0;
        int end=s.length()-1;
        while ( start < end){
            while (start<end && !(('a'<= s.charAt(start) && s.charAt(start)<='z') || ('0'<= s.charAt(start) && s.charAt(start)<='9'))){
                start++;
            }
            while (start<end &&!(('a'<= s.charAt(end) && s.charAt(end)<='z') || ('0'<= s.charAt(end) && s.charAt(end)<='9'))){
                end--;
            }
            if (start < end){
                if (s.charAt(start) != s.charAt(end)){
                    return false;
                }else {
                    start++;
                    end--;
                }
            }
        }
        return true;
    }
}
