package dynamic_programming;

/**
 * 第132题 Palindrome Partitioning II
 *  Given a string s, partition s such that every substring of the partition is a palindrome.

     Return the minimum cuts needed for a palindrome partitioning of s.

     For example, given s = "aab",
     Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * Created by zhaoshiqiang on 2017/7/16.
 */
public class Palindrome_PartitioningII {
    public static int minCut(String s) {
        //判断每个子串是否为回文，可以通过区间动态规划完成
        int[][] dp=new int[s.length()][s.length()];
        //确定最短分割，可以通过线性动态规划完成
        //定义一个新的一维count数组，count[i]用来表示从位置i开始到最后的最小划分个数，这样i和j的方向为i--，j++
        // 这么做是为了使i和j的和计算dp循环顺序一样，这样可以将dp数组和count的计算合并在一起。
        // 如果定义count[i]为从开始到位置i的最小划分，则i和j的方向为i++，j--
        int[] count=new int[s.length()+1];
        for(int i=s.length()-1;i>=0;i--)
        {
            count[i]=Integer.MAX_VALUE;
            for(int j=i;j<s.length();j++)
            {
                if(s.charAt(i)==s.charAt(j)&&(j-i<2||dp[i+1][j-1]==1))
                {
                    dp[i][j]=1;
                    count[i]=Math.min(1+count[j+1],count[i]);
                }
            }
        }

        return count[0]-1;
    }

    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }
}
