/**
 * 第72题
 *  Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

     You have the following 3 operations permitted on a word:

     a) Insert a character
     b) Delete a character
     c) Replace a character
 * Created by zhaoshiqiang on 2017/7/17.
 */
//区间动态规划
public class Edit_Distance {
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        //dp[i][j]表示从word1[0...i-1]到word2[0...j-1]的编辑距离，这里i-1，j-1是为了方便确定初始状态
        int[][] dp = new int[len1 + 1][len2 + 1];
        /*
        * 第一步：确定状态转移方程：
        * dp[i][j]的计算规则有三条：
        * 来自dp[i - i][j - 1]，即 “str1的前i-1个字符组成的子串” 到 “str2的前j-1个字符组成的子串” 的最小距离，此时如果str1[i] = str2[j]，则最短距离不变，否则最短距离加1(即把str1[i]变为str2[j] )，所以dp[i][j] = dp[i - 1][j - 1] + (str1[i] == str2[j] ? 0 : 1)
        * 来自dp[i - 1][j]，即 “A的前i-1个字符组成的子串” 到 “B的前j个字符组成的子串” 的编辑距离。此时删除在A的第i个位置上的字符即可，所以dp[i][j] = dp[i - 1][j] + 1
        * 来自dp[i][j - 1], 即 “A的前i个字符组成的子串” 到 “B的前j-1个字符组成的子串” 的编辑距离。此时在A的子串后面添加一个字符B[j]即可，所以dp[i][j] = dp[i][j - 1] + 1
        * 则状态转移方程：dp[i][j] = min (dp[i - 1][j - 1] + (str1[i-1] == str2[j-1] ? 0 : 1) , dp[i - 1][j] + 1 , dp[i][j - 1] + 1)
        * */
        //第二步，确定初始状态
        for (int i=0; i<=len1; i++){
            dp[i][0] = i;
        }
        for (int j=0; j<=len2; j++){
            dp[0][j] = j;
        }
        //第三步：确定计算顺序，由于要用到i-1，j-1的值，所以计算顺序为i++，j++
        for (int i=1; i<= len1 ; i++){
            for (int j=1; j<= len2; j++){
                dp[i][j] = Math.min(dp[i - 1][j - 1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1), dp[i - 1][j] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("abcd","gbcdz"));
    }
}
