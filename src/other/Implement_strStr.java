package other;

import java.util.List;

/**第28题
 * Implement strStr().

    Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Created by zhaoshiqiang on 2017/1/18.
 */
//KMP算法
public class Implement_strStr {
    public static int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)){
            return 0;
        }
        if (haystack == null || "".equals(haystack)){
            return -1;
        }

        int i=0;
        int j=-1;
        int haystacklength = haystack.length();
        int needlelength = needle.length();
        char[] haystackchar = haystack.toCharArray();
        char[] needlechar = needle.toCharArray();
        int[] next = getNextval(needlechar);
        while (i<haystacklength && j<needlelength){
            //如果j=-1(表示匹配失败)或者当前字符匹配成功(haystackchar[i] == needlechar[j])，都令i++,j++
            if (j == -1 || haystackchar[i] == needlechar[j]){
                i++;
                j++;
            }else {
                //如果j！=-1 且当前字符
                // 匹配失败(haystackchar[i] != needlechar[j])，则令i不变，j=next[j]
                j=next[j];
            }
        }
        if (j == needlelength){
            return i-j;
        }else {
            return -1;
        }
    }
    //next数组表示在第j位不匹配的时候，用第next[j]为和主串匹配
    private static int[] getNextval(char[] p){
        int plen = p.length;
        int[] next = new int[plen];
        //初值赋-1
        next[0]=-1;
        int k=-1;
        int j=0;
        while (j < plen-1){
            //p[k]表示前缀，p[j]表示后缀
            if ( k==-1 || p[j]==p[k]){
                k++;
                j++;
                if (p[k] != p[j]){
                    next[j] = k;
                }else {
                    //因为不能出现p[j]=p[next[j]]，所以当出现是，需要继续递归，k=next[k]=next[next[k]]
                    next[j] = next[k];
                }
            }else {
                k=next[k];
            }
        }
        return next;
    }

    public static void main(String[] args){
        System.out.println(strStr("abecabcabcde","abcabc"));
    }
}
