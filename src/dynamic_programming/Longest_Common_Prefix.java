package dynamic_programming;

/**第14
 * Write a function to find the longest common prefix string amongst an array of strings.
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
