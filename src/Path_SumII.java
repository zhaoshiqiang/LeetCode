import java.util.ArrayList;
import java.util.List;

/**
 * 第113
 *  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
     For example:
     Given the below binary tree and sum = 22,

             5
            / \
          4   8
         /   / \
        11  13  4
      /  \    / \
     7    2  5   1

     return

     [
         [5,4,11,2],
         [5,8,4,5]
     ]

 * Created by zhaoshiqiang on 2017/8/1.
 */
//二叉树 递归
public class Path_SumII {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result,root,sum,new ArrayList<Integer>(),0);
        return result;
    }

    private static void dfs(List<List<Integer>> result, TreeNode root, int sum, ArrayList<Integer> list, int cursum) {
        //结束条件1：如果当前节点为null，则直接返回
        if (root == null){
            return;
        }
        //结束条件2：当前节点为叶子节点且该条路径上和为sum，则添加进result
        if (root.right == null && root.left == null && cursum + root.val == sum){
            list.add(root.val);
            result.add(list);
            return;
        }
        //先将该节点添加进来
        list.add(root.val);
        //递归条件
        dfs(result,root.left,sum,new ArrayList<Integer>(list),cursum + root.val);
        dfs(result,root.right,sum,new ArrayList<Integer>(list),cursum + root.val);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
;