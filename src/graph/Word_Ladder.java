package graph;

import java.util.*;

/**第127题
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
     1、Only one letter can be changed at a time.
     2、Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
     Return 0 if there is no such transformation sequence.
     All words have the same length.
     All words contain only lowercase alphabetic characters.
     You may assume no duplicates in the word list.
     You may assume beginWord and endWord are non-empty and are not the same.
 * Created by zhaoshiqiang on 2017/1/11.
 */
//算法 BFS，数据结构：哈希表
public class Word_Ladder {
    private String start;
    private String end;
    private Set<String> dict;
    //记录每个单词所在的层数
    HashMap<String,Integer> wordlayer = new HashMap<String,Integer>();

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        ArrayList<String> path = new ArrayList<String>();
        if(beginWord==null||endWord==null||beginWord.length()!=endWord.length()) {
            return 0;
        }
        this.start = beginWord;
        this.end = endWord;
        this.dict = wordList;
        dict.add(end);  //方便bfs中判断是否能转化到end中
        dict.remove(start); //防止成环
        if (bfs()){
            return wordlayer.get(end);
        }
        return 0;
    }
    boolean bfs(){
        Queue<String> queue = new LinkedList<>();
        wordlayer.put(start, 1);
        queue.offer(start);
        String current;
        while (!queue.isEmpty()){
            current = queue.poll();
            int length = current.length();
            int layer = wordlayer.get(current);
            for (int i=0; i<length; i++){
                char[] chars = current.toCharArray();
                for (char j='a'; j<='z'; j++){
                    if (chars[i] == j){
                        continue;
                    }
                    chars[i]=j;
                    String newword = String.valueOf(chars);
                    if (dict.contains(newword) && !wordlayer.containsKey(newword)){
                        //找到符合要求的数，对其操作，压入队列
                        wordlayer.put(newword,layer+1);
                        queue.offer(newword);
                        if (newword.equals(end)){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        Word_Ladder word_ladder = new Word_Ladder();
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
//        long startTime = System.currentTimeMillis();//获取当前时间
        System.out.println(word_ladder.ladderLength("hit", "cog", dict));
//        long endTime = System.currentTimeMillis();
//        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
