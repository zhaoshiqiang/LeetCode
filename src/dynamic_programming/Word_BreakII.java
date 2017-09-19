package dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 140题：
 * Given a string s and a dictionary of words dict,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
     Return all such possible sentences.

     For example, given
     s = "catsanddog",
     dict = ["cat", "cats", "and", "sand", "dog"].
     A solution is ["cats and dog", "cat sand dog"]
 * Created by zhaoshiqiang on 2016/12/29.
 */
//线性动态规划+深度优先遍历
public class Word_BreakII {
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        int length = s.length();
        node[] dp = new node[s.length()+1];
        for (int i=0; i<dp.length; i++){
            dp[i] = new node();
        }
        dp[0].sign=true; //初始化，s=""时为true
        for (int i=0; i<=length ;i++){
            if (dp[i].sign == false){
                continue;
            }
            for (String word : wordDict){
                int wordlength = word.length();
                int end = i+wordlength;
                if (end > length){
                    continue;
                }
                if (s.substring(i,end).equals(word)){
                    dp[end].sign=true;
                    dp[i].list.add(end);
                }
            }
        }
        if (dp[length].sign == true){
            //可拆分
            List<String> results = new ArrayList<>();
            List<Integer> indexes = dp[0].list;
            for (Integer index: indexes){
                DFS(s,results,dp,0,index,"");
            }
            return results;
        }else {
            //不可拆分
            return new ArrayList<String>();
        }
    }

    private static void DFS(String s,List<String> results,node[] dp,int start,int end,String substring){
        if (end == s.length()){
            results.add(substring+s.substring(start,end));
        }else {
            List<Integer> indexes = dp[end].list;
            for (Integer index : indexes){
                DFS(s,results,dp,end,index,substring+s.substring(start,end)+" ");
            }
        }
    }

    public static void main(String[] args){
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
//        long startTime = System.currentTimeMillis();//获取当前时间
        List<String> strings = wordBreak("catsanddog", dict);
        for (String s :strings){
            System.out.println(s);
        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

    static class node{
        boolean sign;
        List<Integer> list;

        public node() {
            sign=false;
            list = new ArrayList<>();
        }
    }
}
