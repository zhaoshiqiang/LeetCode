import java.util.LinkedList;
import java.util.Queue;

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
//
public class Minimum_Window_Substring {
    //minWindow的思路是让left指向t中的字符，然后移动right直到找到匹配的串
    //然后从left和right都指向下一个t中的字符，由于right要往回指，所以对于大数据的串会存在超时问题
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
        //当t为单个字符时，下面操作会有问题，所以在上面就直接剔除
        while (right<slength){
            if (mark[schars[right]] > 0){
                if (asciiChars[schars[right]] > 0){
                    asciiChars[schars[right]]--;
                    differentnum--;
                }
                if ( flag == left){
                    //标记下一次开始操作的地方
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
                //开始下一次匹配
                left=flag;
                right=left-1;
                for (int i=0; i<mark.length; i++){
                    asciiChars[i] = mark[i];
                }
                differentnum=tlength;
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
    //minWindowII和minWindowIII的思路一样，都是先移动right，找到匹配串，再移动left，跳过开头没用的字符，
    public static String minWindowII(String s, String t){
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
        int[] needfind=new int[128];
        int[] find=new int[128];
        int left=0,right=0;
        Queue<Integer> queue = new LinkedList<>();
        int differentnum=tlength;
        node minnode=null;
        //记录目标字符串中每个字母出现的次数
        for (int i=0; i<tlength ; i++){
            needfind[tchars[i]]++;
        }
        while (right < slength){
            //每个字符出现次数加1
            find[schars[right]]++;
            if (needfind[schars[right]] > 0 && right!=left){
                queue.offer(right);
            }
            // 如果加1后这个字符的数量不超过目标串中该字符的数量，则找到了一个匹配字符，相异数目减1
            if (needfind[schars[right]] >= find[schars[right]]){
                differentnum--;
            }
            // 如果找到的匹配字符数等于目标串长度，说明找到了一个符合要求的子串
            if (differentnum == 0){
                // 将开头没用的都跳过，没用是指该字符出现次数超过了目标串中出现的次数，并把它们出现次数都减1
                while (left<right && find[schars[left]]>needfind[schars[left]]){
                    find[schars[left]]--;
                    left=queue.poll();
                }
                // 这时候left指向该子串开头的字母，判断该子串长度
                if (minnode==null || minnode.length>right-left+1){
                    minnode=new node(left,right);
                }
                // 把开头的这个匹配字符跳过，并将相异数目+1，子串其实位置+1，开始下一次匹配
                if (!queue.isEmpty()){
                    find[schars[left]]--;
                    left=queue.poll();
                    differentnum++;
                }
            }
            right++;
        }
        if (minnode != null){
            return s.substring(minnode.start,minnode.end);
        }else {
            return "";
        }
    }

    public static String minWindowIII(String S,String T){
        int[] srcHash = new int[255];
        // 记录目标字符串每个字母出现次数
        for(int i = 0; i < T.length(); i++){
            srcHash[T.charAt(i)]++;
        }
        int start = 0,i= 0;
        // 用于记录窗口内每个字母出现次数
        int[] destHash = new int[255];
        int found = 0;
        int begin = -1, end = S.length(), minLength = S.length();
        for(start = i = 0; i < S.length(); i++){
            // 每来一个字符给它的出现次数加1
            destHash[S.charAt(i)]++;
            // 如果加1后这个字符的数量不超过目标串中该字符的数量，则找到了一个匹配字符
            if(destHash[S.charAt(i)] <= srcHash[S.charAt(i)]) found++;
            // 如果找到的匹配字符数等于目标串长度，说明找到了一个符合要求的子串
            if(found == T.length()){
                // 将开头没用的都跳过，没用是指该字符出现次数超过了目标串中出现的次数，并把它们出现次数都减1
                while(start < i && destHash[S.charAt(start)] > srcHash[S.charAt(start)]){
                    destHash[S.charAt(start)]--;
                    start++;
                }
                // 这时候start指向该子串开头的字母，判断该子串长度
                if(i - start < minLength){
                    minLength = i - start;
                    begin = start;
                    end = i;
                }
                // 把开头的这个匹配字符跳过，并将匹配字符数减1
                destHash[S.charAt(start)]--;
                found--;
                // 子串起始位置加1，我们开始看下一个子串了
                start++;
            }
        }
        // 如果begin没有修改过，返回空
        return begin == -1 ? "" : S.substring(begin,end + 1);
    }
    public static void main(String[] args){
        System.out.println(minWindowII("ADOBECODEBANC", "ABC"));
        System.out.println(minWindowII("bba", "ba"));
        System.out.println(minWindowII("abc", "bc"));
        System.out.println(minWindowII("ab", "b"));
        System.out.println(minWindowII("ab", "a"));
    }
}
