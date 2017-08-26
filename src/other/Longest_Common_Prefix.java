package other;

/**第14
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 给定一个String类型数组，要求写一个方法，返回数组中这些字符串的最长公共前缀。
 * 举个例子：假如数组为["123","12","4"]，经过这个方法返回的结果就应该是""。
 * 因为"123"，"12"，"4"并没有共同的前缀，虽然"123"，"12"的公共最长前缀是"12"，
 * 但是这个公共前缀"12"与"4"没有公共前缀，所以最后返回的结果就是""。
 * Created by zhaoshiqiang on 2017/2/11.
 */
//字符串最长公共前缀
public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        if (strs.length==0){
            return "";
        }
        for (int i=0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for (int j=0; j<strs.length; j++){
                if (strs[j].length()<=i){
                    return sb.toString();
                }
                if (strs[j].charAt(i) != c){
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
