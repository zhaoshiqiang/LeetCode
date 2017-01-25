
/**第76题
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
     For example,
     S = "ADOBECODEBANC"
     T = "ABC"
     Minimum window is "BANC".

     Note:
     If there is no such window in S that covers all characters in T, return the empty string "".

     If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * Created by zhaoshiqiang on 2017/1/25.
 */

public class Minimum_Window_Substring {
    public static String minWindow(String s, String t) {
        int slength = s.length();
        int tlength = t.length();
        if (slength == 0){
            return "";
        }
        if (slength == 0){
            return "";
        }
        if (tlength >slength){
            return "";
        }
        if (tlength == 1){
            if (s.contains(t)){
               return t;
            }else {
                return "";
            }
        }
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        int[] asciiChars=new int[128];
        int[] mark=new int[128];
        int left=0,right=0,flag=0;
        int differentnum=tlength;
        node minnode=null;
        for (int i=0; i<tlength ; i++){
            asciiChars[tchars[i]]++;
            mark[tchars[i]]++;
        }
        while (right<slength){
            if (mark[schars[right]] > 0){
                if (asciiChars[schars[right]] > 0){
                    asciiChars[schars[right]]--;
                    differentnum--;
                }
                //right!=left是在s="ab"，t="a"时加上的
                if ( flag == left){
                    flag=right;
                }
            }
            if (differentnum == 0){
                if (minnode == null){
                    minnode=new node(left,right);
                }else {
                    if (minnode.length > right+1-left){
                        minnode=new node(left,right);
                    }
                }
                //flag!=left是在s="ab"，t="a"时加上的
//                if (flag!=left){
                    left=flag;
                    right=left-1;
                    for (int i=0; i<mark.length; i++){
                        asciiChars[i] = mark[i];
                    }
                    differentnum=tlength;
//                }
            }
            right++;
        }
        if (minnode != null){
            return s.substring(minnode.start,minnode.end);
        }else {
            return "";
        }
    }

    static class node{
        int start;
        int end;
        int length;

        public node(int start, int end) {
            this.start = start;
            this.end = end+1;
            this.length=end+1-start;
        }
    }

    public static void main(String[] args){
        System.out.println(minWindow("bba","ba"));
        System.out.println(minWindow("abc","bc"));
        System.out.println(minWindow("ab","b"));
        System.out.println(minWindow("ab","a"));
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
