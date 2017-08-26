package other;

import java.util.ArrayList;
import java.util.List;

/**第438题
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

     Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

     The order of output does not matter.

     Example 1:

     Input:
     s: "cbaebabacd" p: "abc"

     Output:
     [0, 6]

     Explanation:
     The substring with start index = 0 is "cba", which is an anagram of "abc".
     The substring with start index = 6 is "bac", which is an anagram of "abc".
     Example 2:

     Input:
     s: "abab" p: "ab"

     Output:
     [0, 1, 2]

     Explanation:
     The substring with start index = 0 is "ab", which is an anagram of "ab".
     The substring with start index = 1 is "ba", which is an anagram of "ab".
     The substring with start index = 2 is "ab", which is an anagram of "ab".
     Subscribe to see which companies asked this question
 * Created by zhaoshiqiang on 2017/1/16.
 */
//滑动窗口
public class Find_All_Anagrams_in_a_String {

    private static int[] Prime = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> integers = new ArrayList<>();
        if (s == null || s.length() == 0){
            return integers;
        }
        int plength = p.length();
        int slength = s.length();
        int pvalue = getValueByChars(p);
        for (int i=0; i+plength <= slength; i++){
            String newstring = s.substring(i,i+plength);
            if (getValueByChars(newstring) == pvalue){
                integers.add(i);
            }
        }
        return integers;
    }
    //这里用的是判断字符串是否为anagram的方法的第三种方法，(详情参考Group_Anagrams)
    //这个方法的缺陷是当s长度很大时，会超过int的范围，从而失效
    private static Integer getValueByChars(String s){
        char[] schar = s.toCharArray();
        Integer result = 1;
        int length = schar.length;
        for (int i=0; i<length; i++){
            result *= Prime[schar[i]-'a'];
        }
        return result;
    }
    //这里用的是第二种方法，这里假设一共有26个字符
    public static List<Integer> findAnagramsII(String s, String p) {
        List<Integer> re = new ArrayList<Integer>();
        int[] pNum = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pNum[p.charAt(i)-'a']++;
        }

        for (int j = 0; j < s.length() - p.length() + 1; j++) {
            boolean flag = true;
            if (pNum[s.charAt(j)-'a'] >0) {
                String tmp = s.substring(j, j + p.length());
                int[] sNum = new int[26];
                for (int i = 0; i < tmp.length(); i++) {
                    if (pNum[tmp.charAt(i)-'a'] == 0) {
                        flag = false;
                        j+=i;
                        break;
                    } else {
                        sNum[tmp.charAt(i)-'a']++;
                    }
                }
                if (flag && compare(sNum, pNum)) {
                    re.add(j);
                }
            }
        }

        return re;
    }

    public static boolean compare(int[] v1, int[] v2) {
        for (int i = 0; i < v1.length; i++) {
            if (v1[i] != v2[i]) {
                return false;
            }
        }
        return true;
    }
    //这是对第二种方法的一种改进算法，使用滑动窗口，时间复杂度为O(n)
    /*
    * 算法介绍：

        （1）NumberOfDeference = p.length()，用来表示目前窗口中的字符和p的差异度（由于窗口最大时（为p.length()）才有可能使NumberOfDeference为0，
        所以NumberOfDeference 为0时窗口中与p为Anagrams）。NumberOfDeference差异度的含义：一开始窗口左右指针都指向第一个，所以差异度最大为p.length()；
        当窗口中进来一个p中有的字符，差异度就减一，出去一个有的差异度就增一；至于进来或出去的是p中没有的则NumberOfDeference不变，反正窗口的最大值也不过是p.length()。

        （2）窗口的左右两个指针：left和right，分别指向窗口的左端和右端。

        滑动窗口具体操作：

        先滑动右指针，

        1.1 加进来的字符如果该字符在数组asciiChars的计数中非负，则NumberOfDeference减一，否则不做操作，

        1.2无论在不在数组asciiChars该字符相应位置计数都减一

        1.3如果滑动完right，判断如果窗口长度到达p.length()（如果长度到达p.length()，并且NumberOfDeference为0，则将此时的left值加入到result中），滑动左窗口。

        滑动左指针：

        2.1被踢出窗口的那个字符如果在数组asciiChars的计数中非负，则NumberOfDeference增一，不在则不做操作。

        2.2无论在不在数组asciiChars该字符相应位置计数都加一

        （3）上面1.1和2.1操作的原理：asciiChars中的记录的数据是代表p中含有的的每个字符的数量去掉当前窗口中存在的p字符串中每个字符的数量，
        一开始窗口大小为0，啥都不存在，自然asciiChars中记录的就是全部p中含有的的每个字符的数量，如果窗口中有一个，则asciiChars相应的记录中就少一个。
        如果窗口中多包含一个p中没有的（或者包含的某一个字符的数量比p中有的还多），那么这时候，asciiChars中相应的记录值就会变成负数，代表当前窗口中包含相应字符的“多余”的数量。
        所以当进来一个的时候，如果相应记录为非负，那么这个进入是有意义的，则差异度（NumberOfDeference）减一；
        当出去一个的时候，如果相应记录为非负，那么这个出去是有意义的，则差异度（NumberOfDeference）加一。

        （4）asciiChars用到哈希表思想，用来记录p中每一种字符分别有多少个。
    * */
    public static List<Integer> findAnagramsIII(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] asciiChars=new int[26];//记录p中有哪些字符及其数量的数组
        char[] schars = s.toCharArray();
        char[] pchars = p.toCharArray();
        int slength = s.length();
        int plength = p.length();
        int numberOfDeference = p.length(); //差异度指数

        for (int i=0; i<plength; i++){
            asciiChars[pchars[i]-'a']++;
        }
        int left=0; //窗口左指针
        int right=0;//窗口右指针
        //滑动右窗口
        for (;right<slength;right++){
            //该字符相应位置减1
            asciiChars[schars[right]-'a']--;
            //如果加进来的那个数在p中，numberOfDeference减1
            if (asciiChars[schars[right]-'a'] >= 0){
                numberOfDeference--;
            }
            //如果窗口的大小为p.length()
            if (right-left == plength-1){
                //如果numberOfDeference为0，则成功匹配一次，将左窗口添加到result中
                if (numberOfDeference == 0){
                    result.add(left);
                }
                //下面是滑动左窗口的操作
                //如果被踢出的那个字符在p中，则numberOfDeference加1
                if (asciiChars[schars[left]-'a'] >= 0){
                    numberOfDeference++;
                }
                //数组中相应字符的计数加回来
                asciiChars[schars[left]-'a']++;
                left++; //左窗口右滑
            }
        }
        return result;
    }

    public static void main(String[] args){
        List<Integer> integers = findAnagramsIII("cbaebabacd","abc");
        for (Integer i : integers){
            System.out.println(i);
        }
    }
}
