package dynamic_programming;

/**
 * 第44题
 * Implement wildcard pattern matching with support for '?' and '*'.

     '?' Matches any single character.
     '*' Matches any sequence of characters (including the empty sequence).

     The matching should cover the entire input string (not partial).

     The function prototype should be:
     bool isMatch(const char *s, const char *p)

     Some examples:
     isMatch("aa","a") ? false
     isMatch("aa","aa") ? true
     isMatch("aaa","aa") ? false
     isMatch("aa", "*") ? true
     isMatch("aa", "a*") ? true
     isMatch("ab", "?*") ? true
     isMatch("aab", "c*a*b") ? false

 * Created by zhaoshiqiang on 2017/7/17.
 */
//区间动态规划
public class Wildcard_Matching {

    public static boolean isMatch(String s, String p) {
        if ( s == null || p == null){
            return false;
        }
        int m = s.length();
        int n = p.length();
        //dp[i][j]表示串s[0...i-1], p[0...j-1]这两个串分别到i和j位置它们是否匹配
        boolean[][] dp = new boolean[m+1][n+1];
        /*
        * 确定状态转移方程：
        * 当s[i] = p[j]时，比较s[0...i-1]和p[0...j-1]这两个串是否匹配，即dp[i+1][j+1] = dp[i][j];
        * 当p[j] = '?'时，s[i]无论何值都匹配，则比较s[0...i-1]和p[0...j-1]这两个串是否匹配，即dp[i+1][j+1] = dp[i][j];
        * 当p[j] = '*'时，则若s[0...i]和p[0...j-1]匹配（abc，a?c*），则其匹配，或者，若s[0...i-1]和p[0...j]匹配（abcde，a?c*），则其也匹配。即dp[i+1][j+1] = dp[i][j] || dp[i][j];;
        * 其余则为false
        * */
        //确定初始条件
        dp[0][0] = true;
        for (int j = 1; j <= p.length() ; j++){
            dp[0][j] = dp[0][j-1] && p.charAt(j-1) == '*';
        }
        //确定计算顺序：由于要用到i-1，j-1的数据，所以计算顺序为i++，j++
        for (int i=1; i <= m ; i++){
            for (int j=1; j <= n ; j++){
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
    }
}
