/**第58
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

     If the last word does not exist, return 0.

     Note: A word is defined as a character sequence consists of non-space characters only.

     For example,
     Given s = "Hello World",
     return 5
 * Created by zhaoshiqiang on 2017/1/28.
 */
public class Length_of_Last_Word {
    public static int lengthOfLastWord(String s) {
        if (s == null || "".equals(s)){
            return 0;
        }
        String[] strings = s.split(" ");
        int length = strings.length;
        if (length != 0){
            return strings[length-1].trim().length();
        }else {
            return 0;
        }
    }

    public static void main(String[] args){
        System.out.println(lengthOfLastWord(" "));

    }
}
