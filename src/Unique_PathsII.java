/**
 * 第63题
 * Follow up for {@link Unique_Paths}:

     Now consider if some obstacles are added to the grids. How many unique paths would there be?

     An obstacle and empty space is marked as 1 and 0 respectively in the grid.

     For example,

     There is one obstacle in the middle of a 3x3 grid as illustrated below.

     [
         [0,0,0],
         [0,1,0],
         [0,0,0]
     ]

     The total number of unique paths is 2.

     Note: m and n will be at most 100.
 * Created by zhaoshiqiang on 2017/7/16.
 */
//区间动态规划
public class Unique_PathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //dp[i][j]表示走到当前位置的有多少种不同的走法
        int[][] dp = new int[m][n];
        //第一步：确定状态转移方程：
        // 当i>0，j>0时，若要到达i，j位置的路径，只有通过i-1，j 或者 i，j-1，则有方程dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        // 当i=0，或j=0时，若要到达i，j位置的路径，只有通过i-1，0 或者 0，j-1，则有方程dp[i][0] = dp[i-1][0]，dp[0][j] = dp[0][j-1];
        // 当i,j位置上有障碍物时，dp[i][j] = 0；
        //第二步：确定初始条件
        if (obstacleGrid[0][0] == 1){
            dp[0][0] = 0;
        }else {
            dp[0][0] = 1;
        }
        for (int i=1; i < m; i++){
            if (obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
            }else {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int j=1; j < n; j++){
            if (obstacleGrid[0][j] == 1){
                dp[0][j] = 0;
            }else {
                dp[0][j] = dp[0][j-1];
            }

        }
        //第三步：确定计算顺序：因为要用到dp[i - 1][j]和dp[i][j - 1]的数据，所以计算方向为i++，j++
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                if (obstacleGrid[i][j] == 1){
                    //该位置有障碍物
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
