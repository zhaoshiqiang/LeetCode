import java.util.*;

/**第127题
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list
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
        dict.contains(end);
        dict.add(end);
        dict.remove(start);
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
