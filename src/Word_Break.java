import java.util.HashSet;
import java.util.Set;

/**
 * 139题：
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

     For example, given
     s = "leetcode",
     dict = ["leet", "code"].

     Return true because "leetcode" can be segmented as "leet code".
 * Created by zhaoshiqiang on 2016/12/29.
 */
//算法：动态规划-区间
public class Word_Break {
    public static boolean wordBreak(String s, Set<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true; //初始化，s=""时为true
        for (int i=0; i<=length ;i++){
            if (!dp[i]){
                continue;
            }
            for (String word : wordDict){
                int wordlength = word.length();
                int end = i+wordlength;
                if (end > length){
                    continue;
                }
                if (dp[end]){
                    continue;
                }
                if (s.substring(i,end).equals(word)){
                    dp[end]=true;
                }
            }
//            for (int j=0; j<=i; j++){
//                //状态转移
//                if (dp[j] && wordDict.contains(s.substring(j,i))){
//                    dp[i]=true;
//                    break;
//                }
//            }
        }
        return dp[length];
    }
    public static void main(String[] args){
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        long startTime = System.currentTimeMillis();//获取当前时间
        for (int i=0; i<100 ; i++)
            System.out.println(wordBreak("leetcode",dict));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
