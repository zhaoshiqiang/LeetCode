package dynamic_programming;

/**
 * 第64题
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.
 * Created by zhaoshiqiang on 2017/7/16.
 */
//区间动态规划
public class Minimum_Path_Sum {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j]表示当前位置的最小路径和
        int[][] dp = new int[m][n];
        //第一步：确定状态转移方程：
        // 当i>0，j>0时，若要到达i，j位置的路径，只有通过i-1，j 或者 i，j-1，则有方程dp[i][j] = grid[i][j] + min(dp[i - 1][j], dp[i][j - 1]);
        // 当i>0，j=0时，若要到达i，j位置的路径，只有通过i-1，0，则有方程dp[i][0] = grid[i][0] + dp[i-1][0];
        // 当i=0，j>0时，若要到达i，j位置的路径，只有通过0，j-1，则有方程dp[0][j] = grid[0][j] + dp[0][j-1];
        //第二步：确定初始条件
        dp[0][0] = grid[0][0];
        for (int i=1; i < m; i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for (int j=1; j < n; j++){
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }
        //第三步：确定计算顺序：因为要用到dp[i - 1][j]和dp[i][j - 1]的数据，所以计算方向为i++，j++
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] num = new int[][]{{1,2},{1,1}};
        System.out.println(minPathSum(num));
    }
}
