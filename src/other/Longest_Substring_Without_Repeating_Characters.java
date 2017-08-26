package other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**第3题
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Created by zhaoshiqiang on 2017/2/23.
 */
//前后指针构成滑动窗口
public class Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        int length=s.length();
        if (length==0){
            return 0;
        }
        int count=0;
        int max=0;
        Set<Character> set = new HashSet<>();
        int start=0;
        int end=0;
        char[] chars = s.toCharArray();
        while (end<length){
            if (!set.contains(chars[end])){
                set.add(chars[end]);
                count++;
                end++;
            }else {
                if (count>max){
                    max=count;
                }
                while (chars[start]!=chars[end]){
                    set.remove(chars[start]);
                    start++;
                    count--;
                }
                set.remove(chars[start]);
                start++;
                count--;
            }
        }
        max=Math.max(max,count);
        return max;
    }

    public static void main(String[] args){

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }
}
