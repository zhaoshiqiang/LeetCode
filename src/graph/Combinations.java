package graph;

import java.util.ArrayList;
import java.util.List;

/**第77
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 For example,
 If n = 4 and k = 2, a solution is:
     [
         [2,4],
         [3,4],
         [2,3],
         [1,2],
         [1,3],
         [1,4],
     ]
 * Created by zhaoshiqiang on 2017/2/16.
 */
//组合  回溯
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if (k==0 || n==0){
            return ret;
        }
        dfs(ret,1,new ArrayList<Integer>(),k,n);
        return ret;
    }

    private static void dfs(List<List<Integer>> ret,int start,List<Integer> list,int k,int n){
        //当已经选择足够数字时，则加入列表
        if (list.size() == k){
            ret.add(list);
            return;
        }
        //每一种选择数字的可能
        for (int i=start;i<=n;i++){
            list.add(i);
            dfs(ret, i + 1, new ArrayList<Integer>(list), k, n);
            list.remove(list.size()-1);
        }
    }
}
