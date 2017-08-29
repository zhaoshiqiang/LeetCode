package dynamic_programming;

/**
 * 第62题
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

     How many possible unique paths are there?
     Note: m and n will be at most 100.
 * Created by zhaoshiqiang on 2017/7/16.
 */
//区间动态规划
public class Unique_Paths {

    public int uniquePaths(int m, int n) {
        if ( m<0 || n<0){
            return 0;
        }
        //dp[i][j]表示走到当前位置的有多少种不同的走法
        int[][] dp = new int[m][n];
        //第一步：确定状态转移方程：
        // 当i>0，j>0时，若要到达i，j位置的路径，只有通过i-1，j 或者 i，j-1，则有方程dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        // 当i=0，或j=0时，若要到达i，j位置的路径，只有通过i-1，0 或者 0，j-1，则有方程dp[i][0] = 1，dp[0][j] = 1;
        //第二步：确定初始条件
        dp[0][0] = 1;
        for (int i=1; i < m; i++){
            dp[i][0] = 1;
        }
        for (int j=1; j < n; j++){
            dp[0][j] = 1;
        }
        //第三步：确定计算顺序：因为要用到dp[i - 1][j]和dp[i][j - 1]的数据，所以计算方向为i++，j++
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }

}
