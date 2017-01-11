/**
 * 97题：Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 * Created by zhaoshiqiang on 2016/12/29.
 */
//算法：线性动态规划，类似于最长公共子序列
public class Interleaving_string {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int length3=s3.length();
        int length2=s2.length();
        int length1=s1.length();
        if (length1+length2 != length3){
            return false;
        }
        boolean[][] dp = new boolean[length1+1][length2+1];
        //这里表示取一个串中多少个字符，0,1...length
        for (int i=0; i<=length1; i++){
            for (int j=0; j<=length2; j++){
                if (i==0 && j==0){
                    dp[i][j] = true;
                    continue;
                }
                //声明这三个变量是为了更快
                char x=0;
                char y=0;
                char z=0;
                if (i>0){
                    x =s1.charAt(i-1);
                }
                if (j>0){
                    y=s2.charAt(j-1);
                }
                if (i+j>0){
                    z=s3.charAt(i+j-1);
                }
                /*
                如果S1[i]=S2[j]=S3[z]，则dp[i][j] = dp[i-1][j] | dp[i][j-1];
                如果S1[i]=S3[z]，则dp[i][j] = dp[i-1][j];
                如果S2[j]=S3[z]，则dp[i][j]= dp[i][j-1];
                其他则为false
                */
                if (i>0 && j>0 && x == y && y == z){
                    dp[i][j] = dp[i-1][j] | dp[i][j-1];
                }else if (i>0 && x == z){
                    dp[i][j] = dp[i-1][j];
                }else if (j>0 && y == z){
                    dp[i][j]= dp[i][j-1];
                }else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args){
        System.out.println("".substring(0,0));

//        System.out.println(isInterleave("a","","a"));
    }
}
