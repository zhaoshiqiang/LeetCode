package other;

import java.util.*;

/**第49题
 * Given an array of strings,  group anagrams together.

 For example,  given: ["eat",  "tea",  "tan",  "ate",  "nat",  "bat"], 
 Return:
 [
     ["ate",  "eat", "tea"], 
     ["nat", "tan"], 
     ["bat"]
 ]
 Note: All inputs will be in lower-case.
 * Created by zhaoshiqiang on 2017/1/13.
 */
/*
* 判断两个字符串是否为anagram的方法可以有：
    1）将每个字符串的所有字符按字典序排列，比较是否相同。
    2）用长度为26的int数组表示每个字符串的每个字符的出现次数。
    3）用26个素数表示26个字符，字符串表示为所有字符数组对应的素数乘积。这种方法计算很快，但是对字符串的长度有要求，因为字符串太长，对应素数乘积会很大
* */
public class Group_Anagrams {
    private static int[] Prime = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
    public static List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> ss =new ArrayList<>();
        if (strs == null || strs.length==0){
            return ss;
        }
        Map<Integer,List<String>> map = new HashMap<>();
        for (String s : strs){
            //这是用第三种比较方式，这种方式更快
            Integer key = getValueByChars(s);
            if (map.containsKey(key)){
                List<String> strings = map.get(key);
                strings.add(s);
            }else {
                List<String> stringList = new ArrayList<>();
                stringList.add(s);
                map.put(key, stringList);
                ss.add(stringList);
            }
        }
        return ss;
    }
    private static Integer getValueByChars(String s){
        char[] schar = s.toCharArray();
        Integer result = 1;
        int length = schar.length;
        for (int i=0; i<length; i++){
            result *= Prime[schar[i]-'a'];
        }
        return result;
    }

    public static List<List<String>> groupAnagramsII(String[] strs) {
        if (strs.length ==0){
            return new ArrayList<>();
        }
        List<List<String>> ss =new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs){
            char[] schar = s.toCharArray();
            //这里用的是第一种判断方式
            Arrays.sort(schar);
            String key = String.valueOf(schar);
            if (map.containsKey(key)){
                List<String> strings = map.get(key);
                strings.add(s);
            }else {
                List<String> stringList = new ArrayList<>();
                stringList.add(s);
                map.put(key, stringList);
                ss.add(stringList);
            }
        }
        return ss;
    }


    public static void main(String[] args){
        String[] strs = new String[]{"and","dan"};
        List<List<String>> ss = groupAnagrams(strs);
        for (List<String> slist : ss){
            System.out.println();
            for (String s : slist){
                System.out.print(s + ",  ");
            }
        }
    }

}
