package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * 第131 Palindrome Partitioning
 *  Given a string s, partition s such that every substring of the partition is a palindrome.

     Return all possible palindrome partitioning of s.

     For example, given s = "aab",
     Return
         [
             ["aa","b"],
             ["a","a","b"]
         ]

 * Created by zhaoshiqiang on 2017/7/16.
 */
//回文串的判断 + dfs + 区间动态规划
//可以参考博客http://blog.csdn.net/yutianzuijin/article/details/16850031
public class Palindrome_Partitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        if (s == null || s.length()==0){
            return ret;
        }
        boolean[][] palindrome = dp(s);
        /*
        * 得到回文子串的结果之后我们该如何利用去获得所有可能的划分呢？
        * 此时，该问题就变为一个典型的深搜问题，问题的解空间就是所有可能划分的划分树，我们只需要遍历所有的分支直到叶节点，即为一个可能的划分。
        * */
        dfs(palindrome,ret,new ArrayList<String>(),0,s);
        return ret;
    }

    //生成标志回文字符串的数组，partitioning_map[i][j]=1的话，表明：string[i..j]是一个回文字符串
    private static boolean[][] dp(String s){
        int length = s.length();
        char[] chars = s.toCharArray();

        //定义P[i][j]表示字符串从i到j的子串是否为回文串。若p[i][j]=ture的话，表明：string[i..j]是一个回文字符串
        boolean[][] p = new boolean[length][length];
        /*
        * 第一步：确定状态转移方程：
        * 假设现在我们已经知道S(i,j)是回文串，则我们可以在O(1)的时间内知道S(i-1,j+1)是否是回文串。
        * 这是因为字符串S(i-1,j+1)是在字符串S(i,j)的两头各添加一个字符构成的新串，
        * 如果现在满足S(i-1)等于S(j+1)，则说明S(i-1,j+1)是回文串，否则就不是回文串。
        * 从而有状态转移方程：P[i][j] = (str[i] == str[j] && P[i+1][j-1])。
        * */
        /*
        * 第二步：初始化转移矩阵
        * 初始化对角线，当i==j时，p[i][j]是一个字符，其一定是回文串
        * */
        for (int i=0; i<length ; i++){
            p[i][i] = true;
        }
        /*
        * 第三步：确定计算顺序
        * P[i][j]依赖于P[i+1][j-1]，表示我们必须要从最后一行开始(i--)从左到右(j++)计算一个上对角矩阵
        * */
        for (int i=length-2; i>=0 ; i--){
            for (int j=i+1 ; j<length ; j++){
                if (chars[i] == chars[j] && (p[i+1][j-1] || j-i < 2)){
                    p[i][j] = true;
                }else {
                    p[i][j] = false;
                }
            }
        }
        return p;
    }

    private static void dfs(boolean[][] partitionstatus,List<List<String>> ret,List<String> strings,int begin,String s){
        if (begin == s.length()){
            ret.add(strings);
            return;
        }
        for (int i = begin ; i< s.length(); i++){
            if (partitionstatus[begin][i]){
                List<String> temp = new ArrayList<>(strings);
                temp.add(s.substring(begin,i+1));
                dfs(partitionstatus,ret,temp,i+1,s);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = partition("aab");
        for (List<String> strings : lists){
            for (String s : strings){
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
