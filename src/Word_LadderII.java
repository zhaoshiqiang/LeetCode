import java.util.*;

/**第126题
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list
 * Created by zhaoshiqiang on 2017/1/3.
 */
//算法:BFS and DFS数据结构：hashmap
public class Word_LadderII {
    private String start;
    private String end;
    private Set<String> dict;
    //记录每个单词所在的层数
    HashMap<String,Integer> wordlayer = new HashMap<String,Integer>();

    public List<List<String>> findLaddersII(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> path = new ArrayList<String>();
        if(start==null||end==null||start.length()!=end.length()) {
            return result;
        }
        this.start = start;
        this.end = end;
        this.dict = dict;
        dict.contains(end);
        dict.add(end);
        dict.remove(start);
        //从start到end如果存在路径，则生成对应的树，wordlayer记录树中每个单词所在层数
        if (bfs()){
            dfs(start, path, result, wordlayer.keySet());
        }
        return result;
    }

    //bfs生成path
    boolean bfs() {
        Queue<String> queue = new LinkedList();
        queue.offer(start);
        wordlayer.put(start, 0);
        String current;
        while (!queue.isEmpty()){
            current = queue.poll();
            int layer = wordlayer.get(current);
            List<String> strings = stringlistByword(current);
            for (String s : strings){
                //每个单词在path中只能出现一次，也就是每个单词只能出现在一层中，这样就很巧妙的解决了环的问题。
                //将s从dict中移除，这样就保证每次得到string中的字符串必然不会在wordlayer中
                dict.remove(s);
                queue.offer(s);
                wordlayer.put(s,layer+1);
                //已经找到end，则这个最短路径已经存在wordlayer中，深度优先遍历即可得到
                if (s.equals(end)){
                    return true;
                }
            }
        }
        return false;   //没有对应的路径从start到end
    }
    //从目标单词往回找开始单词，记录所有路径
    void dfs(String word,ArrayList<String> pathArray,List<List<String>> result,Set<String> wordset) {

        pathArray.add(word);

        if (word.equals(end)){
            result.add(pathArray);
            return;
        }
        int layer = wordlayer.get(word);
        for (String s : wordset){
            if (wordlayer.get(s) == layer+1 && isOneChange(word,s)){
                dfs(s,new ArrayList<String>(pathArray),result,wordset);
            }
        }
    }

    private List<String> stringlistByword(String word){
        List<String> result = new ArrayList<>();
        for (String s : dict){
            if (isOneChange(word,s)){
                result.add(s);
            }
        }
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
                continue;
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
    void dfs(String start, String end, Set<String> dict, List<String> pathArray,List<List<String>> result) {
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

    public static void main(String[] args){
        Word_LadderII word_ladderII = new Word_LadderII();
        String[] s = {"slit"};
        Set<String> dict = new HashSet<>(Arrays.asList(s));
//        dict.add("hot");
//        dict.add("dot");
//        dict.add("dog");
//        dict.add("lot");
//        dict.add("log");
//        dict.add("a");
//        dict.add("b");
//        dict.add("c");
        long startTime = System.currentTimeMillis();//获取当前时间
//        for (int i=0; i< 10000; i++){
            word_ladderII.findLadders("sand","acne",dict);
//        }
//        for (List<String> strings : ladders){
//            for (String s : strings){
//                System.out.print(s + "    ");
//            }
//            System.out.println();
//        }
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

        long startTime1 = System.currentTimeMillis();//获取当前时间
        for (int i=0; i< 10000; i++){
            word_ladderII.findLaddersII("sand", "acne", dict);
        }
//        for (List<String> strings : ladders){
//            for (String s : strings){
//                System.out.print(s + "    ");
//            }
//            System.out.println();
//        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime1 - startTime1) + "ms");
    }


}
