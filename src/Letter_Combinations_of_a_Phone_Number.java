import java.util.ArrayList;
import java.util.List;

/**第17
 * Given a digit string, return all possible letter combinations that the number could represent.
     A mapping of digit to letters (just like on the telephone buttons) is given below.
     Input:Digit string "23"
     Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 * Created by zhaoshiqiang on 2017/2/25.
 */
//DFS of BFS
public class Letter_Combinations_of_a_Phone_Number {
    private String[] charmap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ret = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length()==0 || digits==null){
            return ret;
        }
        dfs(digits,0,new char[digits.length()]);
        return ret;
    }

    private void dfs(String digits,int index,char[] chars){
        if (index==digits.length()){
            ret.add(new String(chars));
            return;
        }
        char c = digits.charAt(index);
        for (int i=0; i<charmap[c-'0'].length();i++){
            chars[index]=charmap[c-'0'].charAt(i);
            dfs(digits,index+1,chars);
        }
    }
}
