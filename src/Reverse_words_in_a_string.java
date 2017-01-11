import java.util.Stack;

/**
 * 151题：Given an input string, reverse the string word by word.

     For example,
     Given s = "the sky is blue",
     return "blue is sky the".
 * Created by zhaoshiqiang on 2016/12/28.
 */
//数据结构：栈
public class Reverse_words_in_a_string {
    public static String reverseWords(String s) {
        if (s == null){
            return null;
        }
        String[] words = s.split(" ");
        StringBuffer reversewords = new StringBuffer();
        for (int i=words.length-1; i>=0; i--){
            if (!"".equals(words[i])){
                reversewords.append(words[i]).append(" ");
            }
        }
        int length = reversewords.length();
        if (length > 0){
            reversewords.delete(length-1,length);
        }
        return reversewords.toString();
    }


    public static void main(String[] args){
        System.out.println(reverseWords(" 1"));
    }
}
