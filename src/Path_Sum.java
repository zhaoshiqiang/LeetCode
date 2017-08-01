/**
 * 第112
 *  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
     For example:
     Given the below binary tree and sum = 22,

            5
           / \
         4   8
        /   / \
       11  13  4
      /  \      \
     7    2      1

     return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * Created by zhaoshiqiang on 2017/8/1.
 */
//二叉树 递归
public class Path_Sum {

    public boolean hasPathSum(TreeNode root, int sum) {
        //结束条件是如果当前节点是空的，则返回false，
        if (root == null){
            return false;
        }
        // 如果是叶子，那么如果剩余的sum等于当前叶子的值，则找到满足条件的路径，返回true。
        if (root.left == null && root.right == null && root.val == sum){
            return true;
        }
        //递归条件是看左子树或者右子树有没有满足条件的路径，也就是子树路径和等于当前sum-root.val
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

    /**
     *
     * @param p 遍历的节点
     * @param value p的祖先节点之和
     * @param sum 要对比的值
     * @return
     */
    public static boolean checkPathSum(TreeNode p, int value ,int sum){
        if (p == null){
            if (value == sum){
                return true;
            }else {
                return false;
            }
        }
        value += p.val;

        return checkPathSum(p.left,value,sum) || checkPathSum(p.right, value,sum);
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
