/**
 * 第91题
 *  A message containing letters from A-Z is being encoded to numbers using the following mapping:

     'A' -> 1
     'B' -> 2
     ...
     'Z' -> 26

     Given an encoded message containing digits, determine the total number of ways to decode it.

     For example,
     Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

     The number of ways decoding "12" is 2.

 * Created by zhaoshiqiang on 2017/7/16.
 */
//线性动态规划
public class Decode_Ways {

    public static int numDecodings(String s){
        if (s.length()==0||s==null||s=="0")
            return 0;
        //count[i]表示从1~i的decode ways的个数。
        int[] count = new int[s.length() + 1];
        //第一步：确定状态转移方程：
        // 若s[i]是有效的编码数据，而s[i-1,i]不是，则count[i]=count[i-1]，
        // 若s[i]是无效的编码数据，而s[i-1,i]是，则count[i]=count[i-2]，
        // 若s[i]是有效的编码数据，而s[i-1,i]是，则count[i]=count[i-1] + count[i-2]，
        //第二步：初始化转移矩阵
        count[0] = 1;
        if (isValid(s.substring(0,1))){
            count[1] = 1;
        }else {
            count[1] = 0;
        }
        //第三步：确定计算顺序：count[i]需要count[i-1]和count[i-2]的数据，所以i需要从0开始i++
        for (int i=2; i <= s.length(); i++){
            if (isValid(s.substring(i-1,i))){
                count[i] += count[i-1];
            }
            if (isValid(s.substring(i-2,i))){
                count[i] += count[i-2];
            }
        }
        return count[s.length()];
    }

    public static boolean isValid(String s){
        if (s.charAt(0)=='0')
            return false;
        int code = Integer.parseInt(s);
        return code>=1 && code<=26;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("11"));
    }
}
