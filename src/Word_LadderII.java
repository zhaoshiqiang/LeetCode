import java.util.*;

/**第126题
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list
 * Created by zhaoshiqiang on 2017/1/3.
 */
public class Word_LadderII {
    private String beginWord;
    private String endWord;
    private Set<String> wordList;

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> reslut = new ArrayList<>();
        this.beginWord = beginWord;
        this.endWord = endWord;
        if (!wordList.contains(endWord))
            wordList.add(endWord);
        this.wordList = wordList;
        List<String> words = stringlistByword(beginWord,new ArrayList<String>());
        for (String word : words){
            List<String> newStrings = new ArrayList<>();
            newStrings.add(beginWord);
            newStrings.add(word);
            DFS(word,newStrings,reslut);
        }
        int minsize = Integer.MAX_VALUE;
        for (List<String> strings : reslut){
            int size = strings.size();
            if (minsize > size){
                minsize = size;
            }
        }
        for (Iterator it = reslut.iterator(); it.hasNext();){
            List<String> strings = (List<String>) it.next();
            if (minsize != strings.size()){
                it.remove();
            }
        }
//        int sizeresult = reslut.size();
//        for (int i=0; i<sizeresult ; i++){
//            if (minsize != reslut.get(i).size()){
//                reslut.remove(i);
//            }
//        }
        return reslut;
    }

    private void DFS(String word,List<String> strings,List<List<String>> reslut){

        if (word.equals(endWord)){
            reslut.add(strings);
            return;
        }
        List<String> nextwords = stringlistByword(word,strings);
        for (String nextword : nextwords){
            List<String> newStrings = new ArrayList<>();
            newStrings.addAll(strings);
            newStrings.add(nextword);
            DFS(nextword, newStrings, reslut);
        }
    }

    private List<String> stringlistByword(String word,List<String> strings){
        List<String> result = new ArrayList<>();
        for (String s : wordList){
            if (isOneChange(word,s)){
                if (!strings.contains(s))
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
