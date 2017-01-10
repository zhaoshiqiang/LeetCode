import java.util.*;

/**第126题
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list
 * Created by zhaoshiqiang on 2017/1/3.
 */
public class Word_LadderII {
    //记录每个单词所在的层数
    HashMap<String,Integer> path = new HashMap<String,Integer>();
    //bfs生成path
    void bfs(String start, String end, Set<String> dict) {
        Queue queue = new LinkedList<String>();
        queue.add(start);
        path.put(start,0);
        String current;
        while(!queue.isEmpty()) {
            current = (String)queue.poll();
            if(current==end) {
                return;
            }
            for(int i=0;i<current.length();i++) {
                char[] strCharArr = current.toCharArray();
                for(char ch='a';ch<='z';ch++) {
                    if(strCharArr[i]==ch) {
                        continue;
                    }
                    strCharArr[i] = ch;
                    String newWord = new String(strCharArr);
                    if(newWord.equals(end)==true||dict.contains(newWord)) {
                        //每个单词在path中只能出现一次，也就是每个单词只能出现在一层中，这样就很巧妙的解决了环的问题。
                        if(path.get(newWord)==null) {
                            int depth = (int)path.get(current);
                            path.put(newWord,depth + 1);
                            queue.add(newWord);
                        }
                    }
                }
            }
        }
    }
    //从目标单词往回找开始单词，记录所有路径
    void dfs(String start, String end, Set<String> dict, ArrayList<String> pathArray,List<List<String>> result) {
        //找到了，需要reverse加入的所有单词
        if(start.equals(end)==true) {
            pathArray.add(start);
            Collections.reverse(pathArray);
            result.add(pathArray);
            return;
        }
        if(path.get(start)==null) {
            return;
        }
        pathArray.add(start);
        int nextDepth = (int)path.get(start) - 1;
        for(int i=0;i<start.length();i++) {
            char[] strCharArr = start.toCharArray();
            for(char ch='a';ch<='z';ch++) {
                if(strCharArr[i]==ch) {
                    continue;
                }
                strCharArr[i] = ch;
                String newWord = new String(strCharArr);
                //只相差一个字母同时这个单词所在的层数也是当前单词的上一层
                if(path.get(newWord)!=null&&(path.get(newWord)==nextDepth)) {
                    ArrayList<String> newPathArray = new ArrayList<String>(pathArray);
                    dfs(newWord,end,dict,newPathArray,result);
                }
            }
        }
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> path = new ArrayList<String>();
        if(start==null||end==null||start.length()!=end.length()) {
            return result;
        }
        bfs(start, end, dict);
        dfs(end,start, dict, path, result);
        return result;
    }

    private boolean isOneChange(String word1,String word2){
        int length = word1.length();
        int diffient = 0;
        for (int i=0; i<length; i++){
            if (word1.charAt(i) != word2.charAt(i)){
                diffient++;
                if (diffient > 1){
                    return false;
                }
            }
        }
        if (diffient == 1)
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        Word_LadderII word_ladderII = new Word_LadderII();
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
//        dict.add("a");
//        dict.add("b");
//        dict.add("c");
//        long startTime = System.currentTimeMillis();//获取当前时间
        List<List<String>> ladders = word_ladderII.findLadders("hit","cog",dict);
        for (List<String> strings : ladders){
            for (String s : strings){
                System.out.print(s + "    ");
            }
            System.out.println();
        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }


}
