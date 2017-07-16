/**
 * 第70题
 * You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 Note: Given n will be a positive integer.
 * Created by zhaoshiqiang on 2017/7/16.
 */
//线性动态规划
public class Climbing_Stairs {

    public static int climbStairs(int n) {
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
