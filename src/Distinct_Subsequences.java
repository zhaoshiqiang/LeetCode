/**115题
 *  Given a string S and a string T, count the number of distinct subsequences of T in s.

     A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

     Here is an example:
     S = "rabbbit", T = "rabbit"

     Return 3.
 * Created by zhaoshiqiang on 2017/3/27.
 */
//动态规划
public class Distinct_Subsequences {
    /*
    * 无论T的字符与S的字符是否匹配，dp[i][j] = dp[i][j - 1].就是说，假设S已经匹配了j - 1个字符，得到匹配个数为dp[i][j - 1].
    * 现在无论S[j]是不是和T[i]匹配，匹配的个数至少是dp[i][j - 1]。除此之外，当S[j]和T[i]相等时，
    * 我们可以让S[j]和T[i]匹配，然后让S[j - 1]和T[i - 1]去匹配。所以递推关系为：
        dp[0][0] = 1; // T和S都是空串.
        dp[0][1 ... S.length() - 1] = 1; // T是空串，S只有一种子序列匹配。
        dp[1 ... T.length() - 1][0] = 0; // S是空串，T不是空串，S没有子序列匹配。
        dp[i][j] = dp[i][j - 1] + (T[i - 1] == S[j - 1] ? dp[i - 1][j - 1] : 0)
        1 <= i <= T.length(), 1 <= j <= S.length()
    * */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i <=t.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= s.length(); j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                dp[i][j] = dp[i][j - 1];
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

}
