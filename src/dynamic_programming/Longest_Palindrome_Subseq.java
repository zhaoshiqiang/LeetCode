package dynamic_programming;

/**第5
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 * 示例 1:
 * 输入:
 * "bbbab"
 * 输出:
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 * "cbbd"
 * 输出:
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 */
public class Longest_Palindrome_Subseq {
    public String longestPalindromeSubseq(String s) {
        /**
         * 动态规划听起来很高大上。其实说白了就是空间换时间，将计算结果暂存起来，避免重复计算。
         * 我们用一个 boolean dp[l][r] 表示字符串从 i 到 j 这段是否为回文。试想如果 dp[l][r]=true，我们要判断 dp[l-1][r+1] 是否为回文。
         * 只需要判断字符串在(l-1)和（r+1)两个位置是否为相同的字符，是不是减少了很多重复计算。
         * 进入正题，动态规划关键是找到初始状态和状态转移方程。
         * 初始状态，l=r 时，此时 dp[l][r]=true。
         * 状态转移方程，dp[l][r]=true 并且(l-1)和（r+1)两个位置为相同的字符，此时 dp[l-1][r+1]=true。
         *
         */

        if (s == null || s.length()<2){
            return s;
        }
        int size = s.length();
        boolean[][] dp = new boolean[size][size];
        int start = 0;
        int end = 0;
        int max = 1;
        for (int r = 1; r < size; r++) {
            for (int l=r-1; l>=0;l--){
                if (s.charAt(l) == s.charAt(r) && (r-l<=2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                    if(r-l+1 > max){
                        max = r-l+1;
                        start=l;
                        end=r;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }

    public static void main(String[] args) {
        System.out.println(new Longest_Palindrome_Subseq().longestPalindromeSubseq("babad"));
    }
}
